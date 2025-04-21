package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record OrderdItemResponseDTO(
        Long id,
        Long productId,
        Integer quantity,
        BigDecimal price
) {
}
