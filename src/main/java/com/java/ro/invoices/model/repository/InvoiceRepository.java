package com.java.ro.invoices.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.ro.invoices.model.entity.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	List<Invoice> findAll();
}
