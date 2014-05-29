package com.java.ro.invoices.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.ro.invoices.model.entity.TaxRate;
import com.java.ro.invoices.model.service.TaxRateService;

@Controller
public class TaxRateController {

	@Autowired
	private TaxRateService taxRateService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/getTaxRates", method= RequestMethod.GET)
	public @ResponseBody List<TaxRate> getContranctors() {
		return taxRateService.getTaxRates();
	}
}
