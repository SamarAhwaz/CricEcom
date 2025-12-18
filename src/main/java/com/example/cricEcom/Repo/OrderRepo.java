package com.example.cricEcom.Repo;


	import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.Orders;
	
	public interface OrderRepo extends JpaRepository<Orders, Long> {

	}


