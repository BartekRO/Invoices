package com.java.ro.invoices.model.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.java.ro.invoices.model.entity.Invoice;
import com.java.ro.invoices.model.entity.InvoicePosition;
import com.java.ro.invoices.model.entity.InvoiceTaxTotal;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class InvoiceServiceTest  extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	InvoiceService invoiceService;

	@PersistenceContext
	EntityManager entityManager;


	@Test
	public void testSmth() {
		Assert.assertEquals(true, true);
		
		Invoice inv = new Invoice();
		inv.setContractor(null);
		inv.setPositions(new HashSet<InvoicePosition>());
		inv.setTaxTotals(new HashSet<InvoiceTaxTotal>());
		inv.setDateOfIssue(new Date());
		inv.setMaturity(new Date());
		inv.setNumber("123456");
		inv.setSubTotalAmount(BigDecimal.ONE);
		inv.setTotalAmount(BigDecimal.TEN);
		invoiceService.saveInvoice(inv);
		
		entityManager.flush();
		Assert.assertEquals(1, countRowsInTableWhere("Invoice", "  number = '123456'"));
	}
}
