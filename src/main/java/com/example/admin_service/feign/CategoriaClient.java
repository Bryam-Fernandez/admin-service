package com.example.admin_service.feign;

import com.example.admin_service.dto.CategoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface CategoriaClient {

    // LISTAR
    @GetMapping("/api/categorias")
    List<CategoriaDTO> listar();

    // LISTAR PAGINADO
    @GetMapping("/api/categorias/paginado")
    Page<CategoriaDTO> listarPaginado(
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    // BUSCAR
    @GetMapping("/api/categorias/buscar")
    Page<CategoriaDTO> buscar(
            @RequestParam("q") String q,
            @RequestParam("page") int page,
            @RequestParam("size") int size);

    // OBTENER POR ID
    @GetMapping("/api/categorias/{id}")
    CategoriaDTO obtener(@PathVariable("id") Long id);

    // CREAR
    @PostMapping("/api/categorias")
    CategoriaDTO crear(@RequestBody CategoriaDTO categoria);

    // ACTUALIZAR
    @PutMapping("/api/categorias/{id}")
    CategoriaDTO actualizar(
            @PathVariable("id") Long id,
            @RequestBody CategoriaDTO categoria);

    // ELIMINAR
    @DeleteMapping("/api/categorias/{id}")
    void eliminar(@PathVariable("id") Long id);
}