package com.java.ro.invoices.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.ro.invoices.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}
