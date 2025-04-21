package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String productName,
        String productImage,
        String productDescription,
        BigDecimal productPrice,
        Boolean productStatus
) {}
