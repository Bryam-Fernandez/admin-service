package com.example.admin_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.admin_service.dto.ProductoDTO;
import com.example.admin_service.feign.ImgProductoFeign;
import com.example.admin_service.feign.ProductoFeign;

import java.util.List;

@Controller
@RequestMapping("/admin/productos/{productoId}/imagenes")
public class AdminImgProductoController {

  private final ImgProductoFeign imgProductoFeign;
  private final ProductoFeign productoFeign;

  public AdminImgProductoController(ImgProductoFeign imgProductoFeign, ProductoFeign productoFeign) {
    this.imgProductoFeign = imgProductoFeign;
    this.productoFeign = productoFeign;
  }

  @GetMapping
  public String gestionar(@PathVariable Long productoId, Model modelo) {
	  ProductoDTO producto = productoFeign.buscarPorId(productoId);
    modelo.addAttribute("producto", producto);
    modelo.addAttribute("imagenes", imgProductoFeign.buscarPorId(productoId));
    return "admin/productos/imagenes";
  }

  @PostMapping
  public String subir(@PathVariable Long productoId,
                      @RequestParam("files") List<MultipartFile> files,
                      RedirectAttributes attrs) {
	  imgProductoFeign.subirImagenes(productoId, files);
    attrs.addFlashAttribute("msg", "Imágenes cargadas");
    return "redirect:/admin/productos/" + productoId + "/imagenes";
  }

  @PostMapping("/{imagenId}/principal")
  public String principal(@PathVariable Long productoId,
                          @PathVariable Long imagenId,
                          RedirectAttributes attrs) {
	  imgProductoFeign.marcarComoPrincipal(imagenId);
    attrs.addFlashAttribute("msg", "Imagen marcada como principal");
    return "redirect:/admin/productos/" + productoId + "/imagenes";
  }

  @PostMapping("/{imagenId}/eliminar")
  public String eliminar(@PathVariable Long productoId,
                         @PathVariable Long imagenId,
                         RedirectAttributes attrs) {
	  imgProductoFeign.eliminar(imagenId);
    attrs.addFlashAttribute("msg", "Imagen eliminada");
    return "redirect:/admin/productos/" + productoId + "/imagenes";
  }
}
