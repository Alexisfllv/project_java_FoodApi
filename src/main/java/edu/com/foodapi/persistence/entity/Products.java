package edu.com.foodapi.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Products {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productImage;
    private String productDescription;
    private BigDecimal productPrice;
    private Boolean productStatus;
}
