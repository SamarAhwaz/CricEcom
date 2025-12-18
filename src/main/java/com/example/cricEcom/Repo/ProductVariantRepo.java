package com.example.cricEcom.Repo;

import java.util.List;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.ProductVariant;

public interface ProductVariantRepo extends JpaRepository<ProductVariant, Long>{
//	 List<ProductVariant> findByProductId(Long productId);

}
