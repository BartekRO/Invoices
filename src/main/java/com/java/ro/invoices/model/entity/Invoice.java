package com.java.ro.invoices.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Invoice implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String number;
	
	@Column(nullable = false)
	private Date dateOfIssue;
	
	@Column(nullable = false)
	private Date maturity;
	
	@ManyToOne
	@JoinColumn(name = "id_contractor")
	private Contractor contractor;
	
	@OneToMany(mappedBy="invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<InvoicePosition> positions;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal subTotalAmount;
	
	@OneToMany(mappedBy="invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<InvoiceTaxTotal> taxTotals;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal totalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<InvoicePosition> getPositions() {
		return positions;
	}

	public void setPositions(Set<InvoicePosition> positions) {
		this.positions = positions;
	}

	public BigDecimal getSubTotalAmount() {
		return subTotalAmount;
	}

	public void setSubTotalAmount(BigDecimal subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

	public Set<InvoiceTaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(Set<InvoiceTaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
}
