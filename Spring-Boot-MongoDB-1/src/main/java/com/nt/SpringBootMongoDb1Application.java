package com.nt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootMongoDb1Application implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDb1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		
		Employee emp1 = new Employee(1,"Raja",888.99);
		Employee emp2 = new Employee(2,"suresh",9999.9);
		Employee emp3 = new Employee(3,"nitesh",777.77);
		
		repo.save(emp1);
		repo.save(emp2);
		repo.save(emp3);
	}

}
