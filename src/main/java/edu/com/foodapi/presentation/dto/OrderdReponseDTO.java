package edu.com.foodapi.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderdReponseDTO(
        Long id,
        String orderNo,
        LocalDateTime createTime,
        List<OrderdItemResponseDTO> items,
        BigDecimal totalPrice
) {}
