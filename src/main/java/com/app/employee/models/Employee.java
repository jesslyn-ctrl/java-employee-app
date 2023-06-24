package com.app.employee.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;
    
    // Constructors
    public Employee() {
    	super();
	}
    
    public Employee(Long id, String name, Long salary, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}

	// Getters and setters
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
