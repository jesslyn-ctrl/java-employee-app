package com.app.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.employee.dtos.requests.EmployeeRequest;
import com.app.employee.dtos.responses.EmployeeResponse;
import com.app.employee.mappers.EmployeeMapper;
import com.app.employee.models.Employee;
import com.app.employee.models.Grade;
import com.app.employee.repositories.EmployeeRepository;
import com.app.employee.repositories.GradeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final GradeRepository gradeRepository;
	private final EmployeeMapper employeeMapper;
	
	// Dependency injection
	@Autowired
    public EmployeeService(EmployeeRepository employeeRepository, GradeRepository gradeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.gradeRepository = gradeRepository;
        this.employeeMapper = employeeMapper;
    }

	// Create employee data
	public Employee createEmployee(EmployeeRequest request) {
	    int gradeCode = request.getGrade().getCode();
	    Grade grade = gradeRepository.findByCode(gradeCode)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid grade code: " + gradeCode));

	    Employee employee = employeeMapper.mapRequestToEntity(request);
	    employee.setGrade(grade);
	    Employee savedEmployee = employeeRepository.save(employee);

	    return savedEmployee;
	}
    
    // Update employee data
	public Employee updateEmployee(Long id, EmployeeRequest request) {
	    Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Employee not found!"));

	    int gradeCode = request.getGrade().getCode();
	    Grade grade = gradeRepository.findByCode(gradeCode)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid grade code!"));

	    Employee updatedEmployee = employeeMapper.mapRequestToEntity(request);
	    updatedEmployee.setId(employee.getId());
	    updatedEmployee.setGrade(grade);
	    Employee savedEmployee = employeeRepository.save(updatedEmployee);

	    return savedEmployee;
	}

    // Get employee list
    public List<EmployeeResponse> getAllEmployees() {
    	List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.mapEntitiesToResponses(employees);
    }
    
    // Get employee detail
    public Employee getDetailEmployee(Long id) {
    	Optional<Employee> employee = employeeRepository.findById(id);
    	if (employee.isEmpty()) {
            throw new IllegalArgumentException("Employee not found!");
        }
    	
    	return employee.get();
    }
}
