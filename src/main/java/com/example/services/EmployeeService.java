package com.example.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	
	  @Autowired 
	  EmployeeRepository repos;
	 
	
	public Flux<Employee> getAllEmployees(){
		Flux<Employee> listflux = repos.findAll();
		return listflux; 
	}
	
	public Mono<Employee> saveEmployee(Employee employee) {
		Mono<Employee> emp = repos.save(employee);
		
		return emp;
	}
	
	public Mono<Employee> updateEmployee(Long id, Employee emp){
		
		return repos.findById(emp.getId())
				.flatMap(em -> {
					em.setId(emp.getId());					
					em.setLastname(emp.getLastname());
					em.setFirstname(emp.getFirstname());
					em.setGender(emp.getGender());
					em.setDepartment(emp.getDepartment());
					em.setNewEntry(false);
					
					return repos.save(em);
				})
				.switchIfEmpty(repos.save(emp));
				

	}
	
	public Mono<Employee> findEmployee(Long id){
		return repos.findById(id);
	}
	
	public Mono<Void> removeEmployee(Long id){
		return repos.deleteById(id);
	}
	
	public Mono<Employee> findEmployeeByLastname(String lastname){
		return repos.findByLastname(lastname);
	}
}
