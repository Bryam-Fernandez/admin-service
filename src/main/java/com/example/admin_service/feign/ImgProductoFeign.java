package com.example.admin_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.admin_service.dto.ImgProductoDTO;

@FeignClient(name = "img-producto-service", url = "http://localhost:8082")
public interface ImgProductoFeign {

	@GetMapping("/api/img-productos")
	Page<ImgProductoDTO> listarPaginado(
			@RequestParam int page,
			@RequestParam int size);
	
	@GetMapping("/api/img-productos/producto/{productoId}")
	List<ImgProductoDTO> listarPorProducto(
	        @PathVariable("productoId") Long productoId);

	@GetMapping("/api/img-productos/buscar")
	Page<ImgProductoDTO> buscarPorNombreORutaPaginado(
			@RequestParam String q,
			@RequestParam int page,
			@RequestParam int size);
	
	@GetMapping("/admin/productos/url")
	Page<ImgProductoDTO> obtenerUrlPrincipal(Long id);


	@GetMapping("/api/img-productos/{id}")
	ImgProductoDTO buscarPorId(@PathVariable Long id);

	@PostMapping("/api/img-productos")
	ImgProductoDTO crear(@RequestBody ImgProductoDTO imgProducto);

	@PutMapping("/api/img-productos/{id}")
	ImgProductoDTO actualizar(@PathVariable Long id,
							 @RequestBody ImgProductoDTO imgProducto);

	@DeleteMapping("/api/img-productos/{id}")
	void eliminar(@PathVariable Long id);
	
	 @PostMapping( value = "/api/img-productos/subir", consumes = "multipart/form-data")
	 void subirImagenes(@RequestParam("productoId") Long productoId,  @RequestPart("files") List<MultipartFile> files);

	 @PutMapping("/api/img-productos/marcar/{id}")
	 void marcarComoPrincipal(@PathVariable("id") Long imagenId);

}
