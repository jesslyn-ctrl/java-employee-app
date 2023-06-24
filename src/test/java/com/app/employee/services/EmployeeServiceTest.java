package com.app.employee.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.employee.dtos.requests.EmployeeRequest;
import com.app.employee.dtos.requests.GradeRequest;
import com.app.employee.dtos.responses.EmployeeResponse;
import com.app.employee.dtos.responses.GradeResponse;
import com.app.employee.mappers.EmployeeMapper;
import com.app.employee.models.Employee;
import com.app.employee.models.Grade;
import com.app.employee.repositories.EmployeeRepository;
import com.app.employee.repositories.GradeRepository;
import com.github.javafaker.Faker;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
    private EmployeeService employeeService;

	@Autowired
    private EmployeeRepository employeeRepository;

	@Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;
    
    private Faker faker = new Faker();

    @BeforeEach
    public void setup() {
        // Clear all related repository data before test
        employeeRepository.deleteAll();
    }
    
    @Test
    public void testCreateEmployee() {
    	// Create fake data
    	String fakeJob = faker.job().title();
    	String fakeName = faker.name().fullName();
    	int fakeCode = faker.random().nextInt(5, 1001);
    	int fakePercentage = faker.random().nextInt(0, 16);
        long fakeSalary = faker.number().numberBetween(5000000L, 8000000L);
    	
    	// Create a Grade
    	Grade grade = new Grade();
    	grade.setCode(fakeCode);
    	grade.setDescription(fakeJob);
    	grade.setPercentageBonus(fakePercentage);
    	gradeRepository.save(grade);
        
        // Create a request
        EmployeeRequest request = new EmployeeRequest();
        request.setName(fakeName);
        request.setSalary(fakeSalary);
        GradeRequest gradeRequest = new GradeRequest();
        gradeRequest.setCode(fakeCode);
        request.setGrade(gradeRequest);

        // Create an employee
        Employee createdEmployee = employeeService.createEmployee(request);

        // Assert that the employee is created and has the correct data
        assertNotNull(createdEmployee.getId());
        assertEquals(fakeName, createdEmployee.getName());
        assertEquals(fakeSalary, createdEmployee.getSalary());
        assertEquals(grade.getId(), createdEmployee.getGrade().getId());
    }
    
    @Test
    public void testUpdateEmployee() {
    	// Create fake data
    	String fakeJob = faker.job().title();
    	String fakeName = faker.name().fullName();
    	int fakeCode = faker.random().nextInt(5, 1001);
    	int fakePercentage = faker.random().nextInt(0, 16);
        long fakeSalary = faker.number().numberBetween(5000000L, 8000000L);
    	
        // Create a Grade
    	Grade grade = new Grade();
    	grade.setCode(fakeCode);
    	grade.setDescription(fakeJob);
    	grade.setPercentageBonus(fakePercentage);
    	gradeRepository.save(grade);

        // Create an Employee
        Employee employee = new Employee();
        employee.setName(fakeName);
        employee.setSalary(fakeSalary);
        employee.setGrade(grade);
        employeeRepository.save(employee);

        // Create an EmployeeRequest for the update
        EmployeeRequest request = new EmployeeRequest();
        request.setName(fakeName);
        request.setSalary(7100000L);
        GradeRequest gradeRequest = new GradeRequest();
        gradeRequest.setCode(grade.getCode());
        request.setGrade(gradeRequest);

        // Call the updateEmployee method
        Employee updatedEmployee = employeeService.updateEmployee(employee.getId(), request);

        // Verify that the employee is updated and has the correct data
        assertEquals(employee.getId(), updatedEmployee.getId());
        assertEquals(fakeName, updatedEmployee.getName());
        assertEquals(7100000L, updatedEmployee.getSalary());
        assertEquals(grade.getId(), updatedEmployee.getGrade().getId());
    }
    
    @Test
    public void testGetAllEmployees() {
    	// Create fake data
    	String fakeJob1 = faker.job().title();
    	String fakeName1 = faker.name().fullName();
    	int fakeCode1 = faker.random().nextInt(5, 1001);
    	int fakePercentage1 = faker.random().nextInt(0, 16);
        long fakeSalary1 = faker.number().numberBetween(5000000L, 8000000L);
        
        String fakeJob2 = faker.job().title();
    	String fakeName2 = faker.name().fullName();
    	int fakeCode2 = faker.random().nextInt(23, 86);
    	int fakePercentage2 = faker.random().nextInt(16, 20);
        long fakeSalary2 = faker.number().numberBetween(5000000L, 8000000L);
        
        // Create test Grades
        Grade grade1 = new Grade();
    	grade1.setCode(fakeCode1);
    	grade1.setDescription(fakeJob1);
    	grade1.setPercentageBonus(fakePercentage1);
    	gradeRepository.save(grade1);

    	Grade grade2 = new Grade();
    	grade2.setCode(fakeCode2);
    	grade2.setDescription(fakeJob2);
    	grade2.setPercentageBonus(fakePercentage2);
    	gradeRepository.save(grade2);

    	// Create test Employees
    	Employee employee1 = new Employee();
        employee1.setName(fakeName1);
        employee1.setSalary(fakeSalary1);
        employee1.setGrade(grade1);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName(fakeName2);
        employee2.setSalary(fakeSalary2);
        employee2.setGrade(grade2);
        employeeRepository.save(employee2);
        
        // Create grade responses
        GradeResponse gradeResponse1 = new GradeResponse();
        gradeResponse1.setCode(grade1.getCode());
        gradeResponse1.setDescription(grade1.getDescription());
        
        System.out.println(gradeResponse1);
        
        GradeResponse gradeResponse2 = new GradeResponse();
        gradeResponse2.setCode(grade2.getCode());
        gradeResponse2.setDescription(grade2.getDescription());
        
        // Create employee responses
        EmployeeResponse response1 = new EmployeeResponse();
        response1.setId(employee1.getId());
        response1.setName(employee1.getName());
        response1.setSalary(employee1.getSalary());
        response1.setGrade(gradeResponse1);
        response1.setTotalBonus(employee1.getSalary() + employeeMapper.calculateBonus(employee1));

        EmployeeResponse response2 = new EmployeeResponse();
        response2.setId(employee2.getId());
        response2.setName(employee2.getName());
        response2.setSalary(employee2.getSalary());
        response2.setGrade(gradeResponse2);
        response2.setTotalBonus(employee2.getSalary() + employeeMapper.calculateBonus(employee2));

        // Create expected list of employee responses
        List<EmployeeResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(response1);
        expectedResponses.add(response2);

        // Get all employees
        List<EmployeeResponse> actualResponses = employeeService.getAllEmployees();

        // Assert the result
        assertNotNull(actualResponses);
        assertEquals(2, actualResponses.size());
    }
}
