package com.java.ro.invoices.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Entity(name="TUser")
public class User implements Serializable, UserDetails {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 20, unique = true, nullable = false)
	private String username;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles = new HashSet<String>();
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (roles != null) {
			for (String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return authorities;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
