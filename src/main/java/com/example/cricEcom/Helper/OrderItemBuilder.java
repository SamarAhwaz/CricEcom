package com.example.cricEcom.Helper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.cricEcom.entities.OrderItem;
import com.example.cricEcom.entities.Orders;
import com.example.cricEcom.entities.Product;
import com.example.cricEcom.entities.ProductVariant;

@Component
public class OrderItemBuilder {

	 
	    public OrderItem build(Orders order, ProductVariant product, int quantity) {

	        if (quantity <= 0) {
	            throw new IllegalArgumentException("Quantity must be > 0 for product " + product.getId());
	        }

	        Integer stock = product.getStockQuantity();
	        if (stock == null) stock = 0;
	        if (stock < quantity) {
//	            throw new IllegalStateException("Not enough stock for: " + product.getProductName());
	        }

	        BigDecimal unitPrice = product.getPrice();
	        BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));

	        // Deduct stock in-memory, saved on transaction commit
	        product.setStockQuantity(stock - quantity);

	        OrderItem item = new OrderItem();
	        item.setOrder(order);
//	        item.setva(product);
	        item.setQuantity(quantity);
	        item.setUnitPrice(unitPrice);
	        item.setTotalPrice(totalPrice);

	        return item;
	    }
	}


