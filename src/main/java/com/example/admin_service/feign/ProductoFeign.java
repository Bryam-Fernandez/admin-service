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

import com.example.admin_service.dto.ProductoDTO;

@FeignClient(name = "producto-service", url = "http://localhost:8081")
public interface ProductoFeign {
	@GetMapping("/api/productos")
	Page<ProductoDTO> listarPaginado(
			@RequestParam int page,
			@RequestParam int size);

	@GetMapping("/api/productos/buscar")
	Page<ProductoDTO> buscarPorNombreORutaPaginado(
			@RequestParam String q,
			@RequestParam int page,
			@RequestParam int size);

	@GetMapping("/api/productos/{id}")
	ProductoDTO buscarPorId(@PathVariable Long id);

	@PostMapping("/api/productos")
	ProductoDTO crear(@RequestBody ProductoDTO producto);

	@PutMapping("/api/productos/{id}")
	ProductoDTO actualizar(@PathVariable Long id,
							@RequestBody ProductoDTO producto);

	@DeleteMapping("/api/productos/{id}")
	void eliminar(@PathVariable Long id);
}
