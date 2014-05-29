package com.java.ro.invoices.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.ro.invoices.model.entity.TaxRate;
import com.java.ro.invoices.model.repository.TaxRateRepository;

@Service
@Transactional
public class TaxRateService {

	@Autowired
	private TaxRateRepository repository;
	
	public List<TaxRate> getTaxRates() {
		return repository.findAllCacheable();
	}
}
