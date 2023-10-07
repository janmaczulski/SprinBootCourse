package com.example.rest_crud_api.demo.rest;

public class StudentErrorResponse {

	private int status;
	private long timeStamp;
	private String message;

	public StudentErrorResponse(){
	}

	public StudentErrorResponse(int status, long timeStamp, String message) {
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
