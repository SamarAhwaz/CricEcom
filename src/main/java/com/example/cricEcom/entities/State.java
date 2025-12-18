package com.example.cricEcom.entities;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long state_id;
    @Column(nullable = false)
	private String name;

	
	  @ManyToOne(optional = false)
	    private Country country;   // REMOVE if India-only

	    @OneToMany(mappedBy = "state")
	    private List<City> cities;
}
