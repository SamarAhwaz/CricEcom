package com.example.cricEcom.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductVariant {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String variantName; // e.g. "128GB Black"

	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal price;

	    @Column(nullable = false)
	    private Integer stockQuantity;

	    @ManyToOne(optional = false)
	    private Product product;
}

