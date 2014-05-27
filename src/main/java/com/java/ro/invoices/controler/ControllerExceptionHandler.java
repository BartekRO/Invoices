package com.java.ro.invoices.controler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.ro.invoices.model.to.ExceptionTO;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger logger = Logger.getLogger(ControllerExceptionHandler.class);
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
    public @ResponseBody ExceptionTO exception(Exception e) {
		logger.error(e.getMessage(), e);
        return new ExceptionTO(e.getClass().getName(), e.getMessage());
    }
}
