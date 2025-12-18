package com.example.cricEcom.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Address {
	
	
 
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;        // Receiver name

    @Column(nullable = false)
    private String phone;       // Receiver phone

    @Column(nullable = false)
    private String addressLine;

 
    @Column(nullable = false)
    private String pincode;

 
    @Column(nullable = false)
    private Boolean isDefault;

    @ManyToOne(optional = false)
    private User user;
    
    @ManyToOne(optional = false)
    private City city;
    
	

}
