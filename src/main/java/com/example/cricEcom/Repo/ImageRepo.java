package com.example.cricEcom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.ProductImage;

public interface ImageRepo extends JpaRepository<ProductImage, Long>{

}
