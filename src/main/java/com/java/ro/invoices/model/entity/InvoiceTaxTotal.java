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
public class InvoiceTaxTotal implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_taxRate")
	private TaxRate taxRate;
	
	@Column(name = "taxSubtotal", nullable = false, precision = 12, scale = 2)
	private BigDecimal taxSubtotal;
	
	@Column(name = "tax", nullable = false, precision = 12, scale = 2)
	private BigDecimal tax;
	
	@ManyToOne
	@JoinColumn(name = "id_invoce")
	private Invoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getUnitPrice() {
		return taxSubtotal;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.taxSubtotal = unitPrice;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@JsonIgnore
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
