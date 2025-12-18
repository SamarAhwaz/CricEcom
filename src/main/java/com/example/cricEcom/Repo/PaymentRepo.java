package com.example.cricEcom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricEcom.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
