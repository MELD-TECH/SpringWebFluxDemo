package com.example.repository;

import java.util.UUID;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

	Mono<Employee> findByLastname(String lastname);
	
	Mono<Employee> findByFirstname(String firstname);

}
