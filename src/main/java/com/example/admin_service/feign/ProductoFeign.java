package com.example.admin_service.feign;

import com.example.admin_service.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductoFeign {

    // LISTAR PAGINADO
    @GetMapping("/api/productos")
    Page<ProductoDTO> listarPaginado(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    // BUSCAR
    @GetMapping("/api/productos/buscar")
    Page<ProductoDTO> buscar(
            @RequestParam("q") String q,
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    // OBTENER POR ID
    @GetMapping("/api/productos/{id}")
    ProductoDTO buscarPorId(@PathVariable("id") Long id);

    // CREAR
    @PostMapping("/api/productos")
    ProductoDTO crear(
            @RequestBody ProductoDTO producto,
            @RequestParam("categoriaId") Long categoriaId);

    // ACTUALIZAR
    @PutMapping("/api/productos/{id}")
    ProductoDTO actualizar(
            @PathVariable("id") Long id,
            @RequestBody ProductoDTO producto,
            @RequestParam("categoriaId") Long categoriaId);

    // CAMBIAR ESTADO
    @PatchMapping("/api/productos/{id}/estado")
    void habilitar(
            @PathVariable("id") Long id,
            @RequestParam("habilitado") boolean habilitado);

    // ELIMINAR
    @DeleteMapping("/api/productos/{id}")
    void eliminar(@PathVariable("id") Long id);
}