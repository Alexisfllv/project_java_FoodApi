package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record OrderdItemRequestDTO(
        Long idproducto,
        Integer itemQuantity,
        BigDecimal itemTotalPrice
) {}
