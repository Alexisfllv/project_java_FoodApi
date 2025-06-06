package edu.com.foodapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY)
    private Products products;
    private Integer itemQuantity;
    private BigDecimal itemTotalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orderd orderd;
}
