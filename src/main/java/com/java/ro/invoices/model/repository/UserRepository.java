package com.java.ro.invoices.model.repository;

import com.java.ro.invoices.model.entity.User;

public interface UserRepository {
	
	User findUserByUsername(String username);
}
