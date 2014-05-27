package com.java.ro.invoices.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.ro.invoices.model.entity.Contractor;
import com.java.ro.invoices.model.service.ContractorService;

@Controller
public class ContractorController {
	
	@Autowired
	private ContractorService contractorService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/getContractors", method= RequestMethod.GET)
	public @ResponseBody List<Contractor> getContranctors() {
		return contractorService.getContractors();
	}
}
