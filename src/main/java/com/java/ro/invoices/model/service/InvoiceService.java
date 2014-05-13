package com.java.ro.invoices.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.ro.invoices.model.entity.Invoice;
import com.java.ro.invoices.model.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository repository;
	
	public List<Invoice> getInvoices() {
		return repository.findAll();
	}

	public Invoice addInvoice(Invoice invoice) {
		return repository.save(invoice);
	}

	public void removeInvoice(Long id) {
		repository.delete(id);
		
	}
}
