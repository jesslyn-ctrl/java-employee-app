package com.app.employee.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
	@Test
    public void testNullFields() {
        // Create an Employee instance
        Employee employee = new Employee();

        // Assert that all fields are initially null
        assertNull(employee.getId());
        assertNull(employee.getName());
        assertNull(employee.getSalary());
        assertNull(employee.getGrade());

        // Set values to null using the setters
        employee.setId(null);
        employee.setName(null);
        employee.setSalary(null);
        employee.setGrade(null);

        assertNull(employee.getId());
        assertNull(employee.getName());
        assertNull(employee.getSalary());
        assertNull(employee.getGrade());
    }
	
	@Test
    public void testConstructorAndGettersSetters() {
        // Create a Grade instance with empty constructor
        Grade grade = new Grade(1L, 1, "Manager", 10);

        // Create an Employee instance
        Employee employee = new Employee(1L, "John Doe", 5000L, grade);

        // Assert all values with getters
        assertEquals(1L, employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals(5000L, employee.getSalary());
        assertEquals(grade, employee.getGrade());

        // Modify the values using setters
        employee.setId(2L);
        employee.setName("Jane Smith");
        employee.setSalary(6000L);

        // Assert all values after being modified
        assertEquals(2L, employee.getId());
        assertEquals("Jane Smith", employee.getName());
        assertEquals(6000L, employee.getSalary());
    }
}
