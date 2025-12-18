package com.example.cricEcom.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {

	Optional<SubCategory> findByName(String name);
}
