package com.app.employee.dtos.requests;

public class GradeRequest {
	private int code;

	public GradeRequest() {
		super();
	}

	public GradeRequest(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
