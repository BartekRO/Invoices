package com.java.ro.invoices.model.to;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class UserWithTokenTO implements Serializable {
	
	private final UserTO user;
	private final String token;

	public UserWithTokenTO(UserTO user, String token) {
		this.user = user;
		this.token = token;
	}

	public UserTO getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}
}
