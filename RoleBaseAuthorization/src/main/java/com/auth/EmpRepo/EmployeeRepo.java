package com.auth.EmpRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
	
	
	
}
