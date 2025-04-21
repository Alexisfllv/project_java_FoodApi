package edu.com.foodapi.service.inplementation;


import edu.com.foodapi.persistence.entity.OrderItem;
import edu.com.foodapi.persistence.repository.OrderdItemRepository;
import edu.com.foodapi.presentation.dto.OrderdItemResponseDTO;
import edu.com.foodapi.service.interfaces.OrderItemService;
import edu.com.foodapi.util.mapper.OrderItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemImplementation implements OrderItemService {

    private final OrderItemMapper orderItemMapper;
    private final OrderdItemRepository orderdItemRepository;

    @Override
    public List<OrderdItemResponseDTO> listado() {
        List<OrderItem> orderItems = orderdItemRepository.findAll();
        return orderItems
                .stream()
                .map( orderItem -> orderItemMapper.toOrderdItemResponseDTO(orderItem))
                .toList();
    }

    @Override
    public OrderdItemResponseDTO buscar(Long id) {
        OrderItem orderItem = orderdItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found: "+id));
        return orderItemMapper.toOrderdItemResponseDTO(orderItem);
    }
}
