package com.java.ro.invoices.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ro.invoices.model.entity.Contractor;
import com.java.ro.invoices.model.repository.ContractorRepository;

@Service
public class ContractorService {

	@Autowired
	private ContractorRepository repository;
	
	public List<Contractor> getContractors() {
		return repository.findAll();
	}
}
