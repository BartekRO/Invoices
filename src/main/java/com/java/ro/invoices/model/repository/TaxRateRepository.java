package com.java.ro.invoices.model.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.java.ro.invoices.model.entity.TaxRate;

@Repository
public interface TaxRateRepository extends JpaRepository<TaxRate, Long> {
	
	
	@Query(value = "from TaxRate ")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<TaxRate> findAllCacheable();
}
