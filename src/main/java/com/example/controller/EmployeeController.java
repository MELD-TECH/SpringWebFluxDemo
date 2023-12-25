package com.example.controller;

import java.util.UUID;

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

import com.example.model.Employee;
import com.example.services.EmployeeService;

import jakarta.persistence.EntityNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@GetMapping("/findall")
	public ResponseEntity<Flux<Employee>> findAll(){
		
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("save-record")
	public ResponseEntity<Mono<Employee>> createEmployee(@RequestBody Employee employee){
		
//		employee.setId(UUID.randomUUID());
		Mono<Employee> emp = service.saveEmployee(employee);
		
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Mono<Employee>> updateEmployee(@PathVariable Long id,  @RequestBody Employee emp){
		
		Mono<Employee> employee = service.updateEmployee(id, emp);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Mono<Void>> deleteEmployee(@PathVariable Long id) throws EntityNotFoundException{
//		UUID idemp = UUID.fromString(id);
		
		Mono<Void> emp = service.removeEmployee(id);
		
		return new ResponseEntity<>(emp, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/find-record/{id}")
	public ResponseEntity<Mono<Employee>> findRecord(@PathVariable Long id) throws EntityNotFoundException{
		
//		UUID empid = UUID.fromString(id);
		
		Mono<Employee> employee = service.findEmployee(id);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/find-name/{lastname}")
	public ResponseEntity<Mono<Employee>> findLastname(@PathVariable String lastname) throws EntityNotFoundException{

		Mono<Employee> employee = service.findEmployeeByLastname(lastname);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
