package com.java.ro.invoices.model.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.java.ro.invoices.model.entity.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
	
	
	@Query(value = "from Contractor ")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Contractor> findAllCacheable();
}
