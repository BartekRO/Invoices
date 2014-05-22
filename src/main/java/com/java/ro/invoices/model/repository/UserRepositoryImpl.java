package com.java.ro.invoices.model.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.java.ro.invoices.model.entity.User;

@Component(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public User findUserByUsername(String username) {
		try {
			return (User) entityManager.createQuery("from TUser where username = :username").setParameter("username", username)
					.setHint("org.hibernate.cacheable", true).getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	
}
