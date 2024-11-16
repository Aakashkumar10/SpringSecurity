package com.auth.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	public Employee() {
		// Initialize fields with default values
		this.id = 0; // Default value for int
		this.name = ""; // Default value for String
	}

	// Private constructor
	private Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getter methods
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setter for id
	public void setId(int id) {
		this.id = id;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Optionally, a method to create instances of Person, if needed
	public static Employee createPerson(int id, String name) {
		return new Employee(id, name);
	}
}
