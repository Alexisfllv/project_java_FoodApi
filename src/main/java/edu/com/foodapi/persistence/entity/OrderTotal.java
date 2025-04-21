package edu.com.foodapi.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class OrderTotal {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String total_name;
    private BigDecimal total_price;

}
