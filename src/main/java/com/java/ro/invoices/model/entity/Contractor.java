package com.java.ro.invoices.model.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
@Cacheable
public class Contractor implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 255, nullable = false)
	private String addressCityZip;
	
	@Column(length = 255, nullable = false)
	private String addressStreet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressCityZip() {
		return addressCityZip;
	}

	public void setAddressCityZip(String addressCityZip) {
		this.addressCityZip = addressCityZip;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	
	
}
