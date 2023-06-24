package com.app.employee.dtos.responses;

public class GradeResponse {
	private int code;
    private String description;
    
	public GradeResponse() {
		super();
	}
	public GradeResponse(int code, String description) {
		super();
		this.code = code;
		this.description = description;
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
    
    
}
