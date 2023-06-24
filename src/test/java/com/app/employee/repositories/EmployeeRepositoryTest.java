package com.app.employee.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.employee.models.Employee;
import com.app.employee.models.Grade;
import com.github.javafaker.Faker;

@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired
    private EmployeeRepository employeeRepository;
	private Faker faker = new Faker();
	
	@Test
    public void testFindEmployeeById() {
		// Generate random salary using faker
		long randomSalary = faker.number().numberBetween(5000000L, 8000000L);
		
		// Create an employee
		Grade grade = new Grade(3L, 3, "Staff", 3);
        Employee employee = new Employee();
        employee.setName(faker.name().fullName());
        employee.setSalary(randomSalary);
        employee.setGrade(grade);
        employeeRepository.save(employee);

        // Find the employee by Id
		Optional<Employee> foundEmployee = employeeRepository.findById(employee.getId());
		
        // Assert that the employee is found
        assertTrue(foundEmployee.isPresent());
        assertNotNull(foundEmployee.get().getName());
        assertNotNull(foundEmployee.get().getSalary());
    }
}
