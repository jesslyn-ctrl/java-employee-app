package com.app.employee.dtos.requests;

public class EmployeeRequest {
	private String name;
    private Long salary;
    private GradeRequest grade;
    
	public EmployeeRequest() {
		super();
	}
	public EmployeeRequest(String name, Long salary, GradeRequest grade) {
		super();
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public GradeRequest getGrade() {
		return grade;
	}
	public void setGrade(GradeRequest grade) {
		this.grade = grade;
	}
    
}
