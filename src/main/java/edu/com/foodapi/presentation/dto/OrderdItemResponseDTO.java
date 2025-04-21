package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record OrderdItemResponseDTO(
        Long id,
        ProductRequestDTO products,
        Integer itemQuantity,
        BigDecimal itemTotalPrice
) {
}
