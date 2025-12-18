package com.example.cricEcom.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder


@Table(indexes = {
		@Index(name="productIndex",columnList="productName"),
		
})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length=150)
	private String productName;
	@Column(nullable=false,length=2000)
	private String productDesc;
	

   

    @Column(length = 100,nullable=false)
    private String brand;

    @CreationTimestamp
    @Column( updatable = false)
    private LocalDateTime createdAt;
    
    
    @Builder.Default
    private boolean isDeleted=false;

    
    
 
    
    
    @UpdateTimestamp
   
    private LocalDateTime updatedAt;
    

//    @Version
//    @Column(name = "version")
//    private Integer version;

    // One Product -> Many Images
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<ProductImage> images = new ArrayList<>();
    
    

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariant> variants = new ArrayList<>();
    
    
    @ManyToOne(optional = false)
    private SubCategory subCategory;
    
}
