package com.example.admin_service.controller;

import com.bobax.dash.entity.Producto;
import com.bobax.dash.service.CategoriaService;
import com.bobax.dash.service.ImgProductoService;
import com.bobax.dash.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/productos")
public class AdminProductoController {

  private final ProductoService productoService;
  private final CategoriaService categoriaService;
  private final ImgProductoService imgProductoService;

  public AdminProductoController(ProductoService productoService,
                                 CategoriaService categoriaService,
                                 ImgProductoService imgProductoService) {
    this.productoService = productoService;
    this.categoriaService = categoriaService;
    this.imgProductoService = imgProductoService;
  }

 
  @GetMapping
  public String listar(Model modelo,
                       @RequestParam(value = "q", required = false) String q,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       @RequestParam(value = "msg", required = false) String msg) {

    var pagina = (q == null || q.isBlank())
        ? productoService.listarPaginado(page, size)
        : productoService.buscarPorNombreOSkuPaginado(q, page, size);

    Map<Long, String> thumbnails = pagina.getContent().stream()
        .collect(Collectors.toMap(
            Producto::getId,
            p -> imgProductoService.obtenerUrlPrincipal(p.getId())
        ));

    modelo.addAttribute("pagina", pagina);
    modelo.addAttribute("thumbnails", thumbnails);
    modelo.addAttribute("q", q);
    modelo.addAttribute("size", size);
    modelo.addAttribute("msg", msg);
    return "admin/productos/lista";
  }

  
  @GetMapping("/nuevo")
  public String nuevo(Model modelo) {
    modelo.addAttribute("producto", new Producto());
    modelo.addAttribute("categorias", categoriaService.listar());
    modelo.addAttribute("titulo", "Nuevo producto");
    return "admin/productos/form";
  }

  // CREAR
  @PostMapping
  public String crear(@ModelAttribute("producto") Producto producto,
                      @RequestParam("categoriaId") Long categoriaId,
                      RedirectAttributes attrs) {
    productoService.crear(producto, categoriaId);
    attrs.addFlashAttribute("msg", "Producto creado correctamente");
    return "redirect:/admin/productos";
  }


  @GetMapping("/{id}/editar")
  public String editar(@PathVariable Long id, Model modelo, RedirectAttributes attrs) {
    var opt = productoService.buscarPorId(id);
    if (opt.isEmpty()) {
      attrs.addFlashAttribute("msg", "El producto no existe");
      return "redirect:/admin/productos";
    }
    var producto = opt.get();
    modelo.addAttribute("producto", producto);
    modelo.addAttribute("categorias", categoriaService.listar());
    modelo.addAttribute("titulo", "Editar producto");

  
    modelo.addAttribute("urlPrincipal", imgProductoService.obtenerUrlPrincipal(id));

    return "admin/productos/form";
  }

  
  @PostMapping("/{id}")
  public String actualizar(@PathVariable Long id,
                           @ModelAttribute("producto") Producto datos,
                           @RequestParam("categoriaId") Long categoriaId,
                           RedirectAttributes attrs) {
    productoService.actualizar(id, datos, categoriaId);
    attrs.addFlashAttribute("msg", "Producto actualizado");
    return "redirect:/admin/productos";
  }

 
  @PostMapping("/{id}/estado")
  public String cambiarEstado(@PathVariable Long id,
                              @RequestParam("habilitado") boolean habilitado,
                              RedirectAttributes attrs) {
    productoService.habilitar(id, habilitado);
    attrs.addFlashAttribute("msg", "Estado actualizado");
    return "redirect:/admin/productos";
  }

  @PostMapping("/{id}/eliminar")
  public String eliminar(@PathVariable Long id, RedirectAttributes attrs) {
    productoService.eliminar(id);
    attrs.addFlashAttribute("msg", "Producto eliminado");
    return "redirect:/admin/productos";
  }
}
