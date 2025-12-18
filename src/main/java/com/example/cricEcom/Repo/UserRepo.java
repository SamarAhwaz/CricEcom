package com.example.cricEcom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	
	User findByUsername(String username);

}
