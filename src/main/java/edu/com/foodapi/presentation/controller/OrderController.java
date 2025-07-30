package edu.com.foodapi.presentation.controller;


import edu.com.foodapi.presentation.dto.OrderdReponseDTO;
import edu.com.foodapi.presentation.dto.OrderdRequestDTO;
import edu.com.foodapi.service.interfaces.OrderdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderdService orderdService;

    @GetMapping("/listar")
    public ResponseEntity<List<OrderdReponseDTO>> listar() {
        return ResponseEntity.ok(orderdService.findAllOrderd());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OrderdReponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(orderdService.getOrderdReponseById(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<OrderdReponseDTO> registrar(@RequestBody OrderdRequestDTO orderdRequestDTO) {
        return ResponseEntity.ok(orderdService.save(orderdRequestDTO));
    }
}
