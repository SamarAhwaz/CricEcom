package com.example.cricEcom.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cricEcom.Repo.UserRepo;
import com.example.cricEcom.entities.User;

import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;

@SpringBootTest
public class ServiceTest {

	
	@Autowired
	private  UserRepo repo;
		
	@Disabled
	@ParameterizedTest
	@Test
	public void test(){
		
		User user=repo.findByUsername("");
		assertNotNull(repo.findByUsername("asdf"));
	}
	
	@ParameterizedTest
	@CsvSource({"samar",
	"danish",
	"umaie"})
	@Test
	public void testing(String name){
		
		User user=repo.findByUsername("");
		assertNotNull(repo.findByUsername(name));
	}
}
