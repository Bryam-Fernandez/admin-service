package com.example.admin_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.admin_service.dto.EmpleadoDTO;
import com.example.admin_service.dto.EmpleadoFormDTO;
import com.example.admin_service.feign.EmpleadoFeign;

import com.example.admin_service.feign.PuestoTrabajo;

import java.util.Arrays;

@Controller
@RequestMapping("/admin/empleados")
public class AdminEmpleadoController {

  private final EmpleadoFeign empleadoFeign;

  public AdminEmpleadoController(EmpleadoFeign empleadoFeign) {
    this.empleadoFeign = empleadoFeign;
  }

  @GetMapping
  public String listar(Model modelo,
                       @RequestParam(value = "q", required = false) String q,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       @RequestParam(value = "msg", required = false) String msg) {

    var pagina = (q == null || q.isBlank())
        ? empleadoFeign.listarPaginado(page, size)
        : empleadoFeign.buscarPorNombreApellidoPaginado(q, page, size);

    modelo.addAttribute("pagina", pagina); 
    modelo.addAttribute("q", q);
    modelo.addAttribute("size", size);
    modelo.addAttribute("msg", msg);
    return "admin/empleados/lista";
  }


  @GetMapping("/nuevo")
  public String nuevo(Model modelo) {
    modelo.addAttribute("form", new EmpleadoFormDTO());
    modelo.addAttribute("titulo", "Nuevo empleado");
    modelo.addAttribute("puestos", Arrays.asList(PuestoTrabajo.values()));
    return "admin/empleados/form";
  }

  @PostMapping
  public String crear(@ModelAttribute("form") EmpleadoFormDTO form, RedirectAttributes attrs) {
	  empleadoFeign.crear(form);
    attrs.addFlashAttribute("msg", "Empleado creado correctamente");
    return "redirect:/admin/empleados";
  }

  @GetMapping("/{id}/editar")
  public String editar(@PathVariable Long id, Model modelo, RedirectAttributes attrs) {
      

      EmpleadoDTO emp = empleadoFeign.buscarPorId(id);
      

      if (emp == null) {
          attrs.addFlashAttribute("msg", "El empleado no existe");
          return "redirect:/admin/empleados";
      }

      EmpleadoFormDTO form = new EmpleadoFormDTO();
      form.setId(emp.getId());
      form.setUsuario(emp.getUsuario().getUsername());
      form.setHabilitado(emp.getUsuario().isEnabled());
      form.setNombre(emp.getNombre());
      form.setApellido(emp.getApellido());
      form.setCorreo(emp.getCorreo());
      form.setDni(emp.getDni());
      form.setSalario(emp.getSalario());
      form.setPuesto(emp.getPuesto());

      // Agregar atributos al modelo
      modelo.addAttribute("form", form);
      modelo.addAttribute("titulo", "Editar empleado");
      modelo.addAttribute("puestos", Arrays.asList(PuestoTrabajo.values()));
      
      return "admin/empleados/form";
  }

  @PostMapping("/{id}")
  public String actualizar(@PathVariable Long id,
                           @ModelAttribute("form") EmpleadoFormDTO form,
                           RedirectAttributes attrs) {
	  empleadoFeign.actualizar(id, form);
    attrs.addFlashAttribute("msg", "Empleado actualizado");
    return "redirect:/admin/empleados";
  }

  @PostMapping("/{id}/eliminar")
  public String eliminar(@PathVariable Long id, RedirectAttributes attrs) {
	  empleadoFeign.eliminar(id);
    attrs.addFlashAttribute("msg", "Empleado eliminado");
    return "redirect:/admin/empleados";
  }
  
  

}
