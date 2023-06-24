package com.app.employee.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.app.employee.dtos.requests.EmployeeRequest;
import com.app.employee.dtos.responses.EmployeeResponse;
import com.app.employee.dtos.responses.GradeResponse;
import com.app.employee.models.Employee;
import com.app.employee.models.Grade;

@Component
public class EmployeeMapper {
	// Map the fields from request DTO
    public Employee mapRequestToEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSalary(employeeRequest.getSalary());
        return employee;
    }
    
    // Get response in list
    public List<EmployeeResponse> mapEntitiesToResponses(List<Employee> employees) {
    	return employees.stream()
    			.map(this::mapEntityToResponse)
    	        .collect(Collectors.toList());
    }
    
    // Calculate bonus for employee
    public Long calculateBonus(Employee employee) {
    	Grade grade = employee.getGrade();
    	if (grade != null) {
    		float bonus = grade.getPercentageBonus() / 100;
    		return (long) (employee.getSalary() * bonus);
    	}
    	return 0L;
    }
    
    // Map the fields from response DTO
    private EmployeeResponse mapEntityToResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setSalary(employee.getSalary());

        GradeResponse gradeResponse = new GradeResponse();
        gradeResponse.setCode(employee.getGrade().getCode());
        gradeResponse.setDescription(employee.getGrade().getDescription());
        response.setGrade(gradeResponse);

        long totalBonus = employee.getSalary() + calculateBonus(employee);
        response.setTotalBonus(totalBonus);

        return response;
    }
    
}
