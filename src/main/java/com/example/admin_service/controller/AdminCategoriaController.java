package com.example.admin_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.admin_service.dto.CategoriaDTO;
import com.example.admin_service.feign.CategoriaClient;


@Controller
@RequestMapping("/admin/categorias")
public class AdminCategoriaController {

    private final CategoriaClient categoriaClient;

    public AdminCategoriaController(CategoriaClient categoriaClient) {
        this.categoriaClient = categoriaClient;
    }

    // =========================
    // LISTAR
    // =========================
    @GetMapping
    public String listar(Model modelo,
                         @RequestParam(value = "q", required = false) String q,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "msg", required = false) String msg) {

        var pagina = (q == null || q.isBlank())
                ? categoriaClient.listarPaginado(page, size)
                : categoriaClient.buscarPorNombreORutaPaginado(q, page, size);

        modelo.addAttribute("pagina", pagina);
        modelo.addAttribute("q", q);
        modelo.addAttribute("size", size);
        modelo.addAttribute("msg", msg);

        return "admin/categorias/lista";
    }

    // =========================
    // FORM NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("categoria", new CategoriaDTO());
        modelo.addAttribute("titulo", "Nueva categoría");
        return "admin/categorias/form";
    }

    // =========================
    // CREAR
    // =========================
    @PostMapping
    public String crear(@ModelAttribute("categoria") CategoriaDTO categoria,
                        RedirectAttributes attrs) {

        categoriaClient.crear(categoria);
        attrs.addFlashAttribute("msg", "Categoría creada correctamente");

        return "redirect:/admin/categorias";
    }

    // =========================
    // EDITAR FORM
    // =========================
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id,
                         Model modelo,
                         RedirectAttributes attrs) {

        try {
            CategoriaDTO categoria = categoriaClient.buscarPorId(id);
            modelo.addAttribute("categoria", categoria);
            modelo.addAttribute("titulo", "Editar categoría");
            return "admin/categorias/form";
        } catch (Exception e) {
            attrs.addFlashAttribute("msg", "La categoría no existe");
            return "redirect:/admin/categorias";
        }
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @ModelAttribute("categoria") CategoriaDTO categoria,
                             RedirectAttributes attrs) {

        categoriaClient.actualizar(id, categoria);
        attrs.addFlashAttribute("msg", "Categoría actualizada");

        return "redirect:/admin/categorias";
    }

    // =========================
    // ELIMINAR
    // =========================
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id,
                           RedirectAttributes attrs) {

        categoriaClient.eliminar(id);
        attrs.addFlashAttribute("msg", "Categoría eliminada");

        return "redirect:/admin/categorias";
    }
}