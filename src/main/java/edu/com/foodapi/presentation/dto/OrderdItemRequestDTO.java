package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record OrderdItemRequestDTO(
        Long productId,
        Integer quantity,
        BigDecimal price
) {
}
