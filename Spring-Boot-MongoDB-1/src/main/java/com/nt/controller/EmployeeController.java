package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;

@RestController
@RequestMapping("/rest/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repo; 
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Employee getByEmployeeId(@PathVariable(value="id") Integer id){
		return repo.findById(id).get();
	}
	
	@PostMapping("/addemployee")
	public List<Employee> addEmployee(@RequestBody Employee emp){
		repo.save(emp);
		return repo.findAll();
	}
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Integer id, @RequestBody Employee emp){
		Optional<Employee> findById = repo.findById(id);
		if(findById.isPresent()) {
			Employee emp2 =  repo.save(emp);
			return new ResponseEntity<Employee>(emp2,HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable(value="id")Integer id){
			Optional opt = repo.findById(id);
			if(opt.isPresent()) {
				repo.deleteById(id);
				return new ResponseEntity<String>("Employee Deleted",HttpStatus.OK);
			}
			return new ResponseEntity("Employee not Found",HttpStatus.NOT_FOUND);
	}
	
}
