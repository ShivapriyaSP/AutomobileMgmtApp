package com.mindtree.AutomobileManagement.Exception;

import java.util.Date;

public class ErrorDetails {
	private Date date;
	private String message;
	private String description;
	
	
	public ErrorDetails() {
		super();
	}


	public ErrorDetails(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public String getMessage() {
		return message;
	}


	public String getDescription() {
		return description;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
