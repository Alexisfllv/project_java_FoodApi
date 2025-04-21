package edu.com.foodapi.presentation.controller;


import edu.com.foodapi.presentation.dto.ProductRequestDTO;
import edu.com.foodapi.presentation.dto.ProductResponseDTO;
import edu.com.foodapi.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductResponseDTO>> listar() {
        return ResponseEntity.ok(productService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProductResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(productService.buscarPorId(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProductResponseDTO> registrar(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.salvar(productRequestDTO));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ProductResponseDTO> modificar (@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.alterar(productRequestDTO,id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductResponseDTO> eliminar(@PathVariable Long id) {
        productService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
