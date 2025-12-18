package com.example.cricEcom.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

	public enum OrderStatus {
		PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED, FAILED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private User user;

	private BigDecimal totalAmount;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus; // PENDING, CONFIRMED, SHIPPED, DELIVERED

	private LocalDateTime orderedAt;
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items;

	@PrePersist
	public void prePersist() {
		orderedAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
		if (orderStatus == null)
			orderStatus = OrderStatus.PENDING;
			}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
//	}
//
//	private void calculateTotalAmount() {
//	    if (items != null && !items.isEmpty()) {
//	        totalAmount = items.stream()
//	            .map(item -> item.getTotalPrice() == null ? BigDecimal.ZERO : item.getTotalPrice())
//	            .reduce(BigDecimal.ZERO, BigDecimal::add);
//	    } else {
//	        totalAmount = BigDecimal.ZERO;
//	    }
//	}

}
