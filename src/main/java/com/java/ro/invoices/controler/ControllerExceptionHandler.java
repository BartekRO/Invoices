package com.java.ro.invoices.controler;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.ro.invoices.model.to.ExceptionTO;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AuthenticationException.class)
    public @ResponseBody ExceptionTO exception(AuthenticationException e) {
        return new ExceptionTO(e.getClass().getName(), e.getMessage());
    }
}
