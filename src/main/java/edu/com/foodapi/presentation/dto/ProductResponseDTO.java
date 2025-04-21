package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String productName,
        String productImage,
        String productDescription,
       BigDecimal productPrice,
        Boolean productStatus
) {}
