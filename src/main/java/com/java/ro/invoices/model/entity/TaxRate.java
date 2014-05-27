package com.java.ro.invoices.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
@Cacheable
public class TaxRate implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "description", nullable = false, length = 10)
	private String description;
	
	@Column(name = "rate", nullable = false, precision = 10, scale = 2)
	private BigDecimal rate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
