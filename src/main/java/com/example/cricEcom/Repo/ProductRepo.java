package com.example.cricEcom.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.example.cricEcom.entities.Product;

import jakarta.persistence.LockModeType;

public interface ProductRepo extends  JpaRepository<Product, Long>{
	
	 @Lock(LockModeType.PESSIMISTIC_WRITE)
	    @Query("select p from Product p where p.id = :id")
	    Optional<Product> findByIdForUpdate(Long id);

}
