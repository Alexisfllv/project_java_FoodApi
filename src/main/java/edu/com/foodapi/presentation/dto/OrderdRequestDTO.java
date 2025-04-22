package edu.com.foodapi.presentation.dto;

import edu.com.foodapi.persistence.entity.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderdRequestDTO(
        String orderNo,
        List<OrderdItemRequestDTO> items,
        BigDecimal totalPrice
) { }
