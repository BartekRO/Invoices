package com.java.ro.invoices.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.ro.invoices.model.entity.Invoice;
import com.java.ro.invoices.model.repository.InvoiceRepository;
import com.java.ro.invoices.model.to.DataTO;

@Service
@Transactional
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository repository;
	
	public DataTO<Invoice> getInvoices(int page, int size) {
		Page<Invoice> data = repository.findAllInvoicesWithPositions(new PageRequest(page - 1, size));
		DataTO<Invoice> result = new DataTO<Invoice>();
		result.setRecords(data.getContent());
		result.setTotal(data.getTotalElements());
		
		
//		List<Invoice> data = repository.findAllWithkdsfjkdsj();
//		DataTO<Invoice> result = new DataTO<Invoice>();
//		result.setRecords(data);
//		result.setTotal(data.size());
		return result;
	}

	public Invoice addInvoice(Invoice invoice) {
		return repository.save(invoice);
	}

	public void removeInvoice(Long id) {
		repository.delete(id);
		
	}
}
