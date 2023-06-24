package com.app.employee.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private int code;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "percentage_bonus", nullable = false)
    private float percentageBonus;
    
    // Constructors
    public Grade() {
    	super();
	}
    
    public Grade(Long id, int code, String description, float percentageBonus) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
        this.percentageBonus = percentageBonus;
    }

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	public float getPercentageBonus() {
        return percentageBonus;
    }

    public void setPercentageBonus(float percentageBonus) {
        this.percentageBonus = percentageBonus;
    }
}
