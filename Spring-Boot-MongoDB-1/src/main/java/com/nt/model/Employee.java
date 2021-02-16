package com.nt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Employee")
public class Employee {

	@Id
	private Integer empNo;
	private String empName;
	private Double salary;
	
	public Employee(Integer empNo, String empName, Double salary) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}
	
	
}
