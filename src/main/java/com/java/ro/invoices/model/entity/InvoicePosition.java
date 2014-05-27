package com.java.ro.invoices.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class InvoicePosition implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	
	@Column(name = "quantity", nullable = false, precision = 6, scale = 2)
	private BigDecimal quantity; 
	
	@Column(name = "unitPrice", nullable = false, precision = 10, scale = 2)
	private BigDecimal unitPrice;
	
	@Column(name = "total", nullable = false, precision = 12, scale = 2)
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "id_taxRate")
	private TaxRate taxRate;
	
	@ManyToOne
	@JoinColumn(name = "id_invoce")
	private Invoice invoice;

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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	@JsonIgnore
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
}
