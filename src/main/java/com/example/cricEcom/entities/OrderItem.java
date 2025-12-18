package com.example.cricEcom.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
     private Orders order;

    @ManyToOne(optional = false)
    private ProductVariant variant;

   @Column(nullable = false)
    private int quantity;

    // Price of ONE unit of the product at the time of ordering
    @Column(nullable = false)	
    private BigDecimal unitPrice;

    // Calculated: unitPrice * quantity, stored for audit purposes
    @Column(nullable = false)
    private BigDecimal totalPrice;
    
//    @PrePersist
//    @PreUpdate
//    public void calculateTotal() {
//        if (unitPrice == null) {
//            throw new IllegalStateException("unitPrice cannot be null when saving OrderItem");
//        }
//        this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
//    }

}
