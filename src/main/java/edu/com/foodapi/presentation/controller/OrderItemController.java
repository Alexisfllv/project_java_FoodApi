package edu.com.foodapi.presentation.controller;


import edu.com.foodapi.presentation.dto.OrderdItemResponseDTO;
import edu.com.foodapi.service.interfaces.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-item")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/listar")
    public ResponseEntity<List<OrderdItemResponseDTO>> listado() {
        return ResponseEntity.ok(orderItemService.listado());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OrderdItemResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.buscar(id));
    }
}
