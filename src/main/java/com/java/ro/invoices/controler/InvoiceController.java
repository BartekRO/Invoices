package com.java.ro.invoices.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.ro.invoices.model.entity.Invoice;
import com.java.ro.invoices.model.service.InvoiceService;
import com.java.ro.invoices.model.to.DataTO;

@Controller
public class InvoiceController {
	
	
	@Autowired
	private InvoiceService invoiceService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/getInvoices", method= RequestMethod.GET)
	public @ResponseBody DataTO<Invoice> getInvoices(@RequestParam int page, @RequestParam int count) {
		return invoiceService.getInvoices(page, count);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/addInvoice", method = RequestMethod.POST)
	public @ResponseBody String addInvoice(@RequestBody Invoice invoice) {
		invoiceService.addInvoice(invoice);
		return "";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/removeInvoice", method = RequestMethod.POST)
	public @ResponseBody String removeInvoice(@RequestBody Long id) {
		invoiceService.removeInvoice(id);
		return "";
	}
}
