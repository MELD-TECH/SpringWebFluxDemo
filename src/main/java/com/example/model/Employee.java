/**
 * 
 */
package com.example.model;

import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
@Entity
public class Employee implements Persistable<Long> {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String lastname;
	
	private String firstname;
	
	private String department;
	
	private String gender; 
	
	@Transient
	@Builder.Default
	private boolean isNewEntry = true;

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNewEntry;
	}
	
	
}
