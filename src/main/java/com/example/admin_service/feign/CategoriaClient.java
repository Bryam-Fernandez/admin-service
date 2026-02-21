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

import com.example.admin_service.dto.CategoriaDTO;

@FeignClient(name = "producto-service", url = "http://localhost:8082")
public interface CategoriaClient {

    @GetMapping("/api/categorias")
    Page<CategoriaDTO> listarPaginado(
            @RequestParam int page,
            @RequestParam int size);

    @GetMapping("/api/categorias/buscar")
    Page<CategoriaDTO> buscarPorNombreORutaPaginado(
            @RequestParam String q,
            @RequestParam int page,
            @RequestParam int size);

    @GetMapping("/api/categorias/{id}")
    CategoriaDTO buscarPorId(@PathVariable Long id);

    @PostMapping("/api/categorias")
    CategoriaDTO crear(@RequestBody CategoriaDTO categoria);

    @PutMapping("/api/categorias/{id}")
    CategoriaDTO actualizar(@PathVariable Long id,
                            @RequestBody CategoriaDTO categoria);

    @DeleteMapping("/api/categorias/{id}")
    void eliminar(@PathVariable Long id);
}