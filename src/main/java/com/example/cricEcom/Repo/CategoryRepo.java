package com.example.cricEcom.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
	
	Optional<Category> findByName(String name);


}
