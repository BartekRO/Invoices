package com.java.ro.invoices.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.ro.invoices.model.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
	@Query(value = "select inv from Invoice inv left join fetch inv.positions pos left join fetch inv.taxTotals tot left join fetch inv.contractor ", 
			countQuery = "select count(inv) from Invoice inv")
	Page<Invoice> findAllInvoicesWithPositions(Pageable pageable);
}
