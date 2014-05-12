package com.java.ro.invoices.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.ro.invoices.model.entity.Invoice;
import com.java.ro.invoices.model.service.InvoiceService;

@Controller
public class InvoiceControler {
	
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value="/getInvoices", method= RequestMethod.GET)
	public @ResponseBody List<Invoice> getInvoices() {
		return invoiceService.getInvoices();
	}
	
}
