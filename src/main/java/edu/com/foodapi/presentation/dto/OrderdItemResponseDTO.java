package edu.com.foodapi.presentation.dto;

import edu.com.foodapi.persistence.entity.Orderd;

import java.math.BigDecimal;

public record OrderdItemResponseDTO(
        Long id,
        ProductRequestDTO products,
        Integer itemQuantity,
        BigDecimal itemTotalPrice,
        Long orderdId
) {}
