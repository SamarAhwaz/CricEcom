package com.example.cricEcom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

}
