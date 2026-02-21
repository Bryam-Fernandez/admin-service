package com.example.admin_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.admin_service.dto.EmpleadoDTO;
import com.example.admin_service.dto.EmpleadoFormDTO;

@FeignClient(name = "employee-service", url = "http://localhost:8083/empleado")
public interface EmpleadoFeign {

	    // LISTAR PAGINADO
	    @GetMapping("/api/empleados")
	    Page<EmpleadoDTO> listarPaginado(
	            @RequestParam int page,
	            @RequestParam int size);

	    // BUSCAR CON FILTRO
	    @GetMapping("/api/empleados/buscar")
	    Page<EmpleadoDTO> buscarPorNombreApellidoPaginado(
	            @RequestParam String q,
	            @RequestParam int page,
	            @RequestParam int size);

	    // BUSCAR POR ID
	    @GetMapping("/api/empleados/{id}")
	    EmpleadoDTO buscarPorId(@PathVariable Long id);

	    // CREAR
	    @PostMapping("/api/empleados")
	    EmpleadoDTO crear(@RequestBody EmpleadoFormDTO form);

	    // ACTUALIZAR
	    @PutMapping("/api/empleados/{id}")
	    EmpleadoDTO actualizar(@PathVariable Long id,
	                           @RequestBody EmpleadoFormDTO form);

	    // ELIMINAR
	    @DeleteMapping("/api/empleados/{id}")
	    void eliminar(@PathVariable Long id);
	    
}
