package com.auth.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.EmpRepo.EmployeeRepo;
import com.auth.Entity.Employee;

@RestController
public class EmpController {

	@Autowired
	EmployeeRepo employeeRepo;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();

	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);

	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {

		Employee existing = employeeRepo.findById(id).get();
		existing.setName(employee.getName());
		employeeRepo.save(existing);
		return existing;
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> delete(@PathVariable int id) {

		Employee existing = employeeRepo.findById(id).get();
		employeeRepo.delete(existing);

		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return response;

	}

}
