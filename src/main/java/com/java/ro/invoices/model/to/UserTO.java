package com.java.ro.invoices.model.to;

import java.util.Map;

public final class UserTO {
	private final String username;
	private final Map<String, Boolean> roles;
	
	public UserTO(String username, Map<String, Boolean> roles) {
		this.username = username;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public Map<String, Boolean> getRoles() {
		return roles;
	}

}
