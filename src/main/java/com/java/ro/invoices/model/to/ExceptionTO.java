package com.java.ro.invoices.model.to;

public class ExceptionTO {
	
	private String name;
	private String message;
	
	public ExceptionTO(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
