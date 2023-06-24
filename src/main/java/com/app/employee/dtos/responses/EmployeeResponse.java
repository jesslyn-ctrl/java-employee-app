package com.app.employee.dtos.responses;

public class EmployeeResponse {
	private Long id;
    private String name;
    private Long salary;
    private GradeResponse grade;
    private Long totalBonus;
    
	public EmployeeResponse() {
		super();
	}

	public EmployeeResponse(Long id, String name, Long salary, GradeResponse grade, Long totalBonus) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.totalBonus = totalBonus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public GradeResponse getGrade() {
		return grade;
	}
	public void setGrade(GradeResponse grade) {
		this.grade = grade;
	}
	public Long getTotalBonus() {
		return totalBonus;
	}
	public void setTotalBonus(Long totalBonus) {
		this.totalBonus = totalBonus;
	}
    
    
}
