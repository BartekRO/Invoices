package com.java.ro.invoices.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.ro.invoices.model.entity.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
	
	public List<Contractor> findAll();
}
