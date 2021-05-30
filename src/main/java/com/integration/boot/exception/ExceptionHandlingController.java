package com.integration.boot.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.integration.boot.service.CustomerService;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
	
	@Autowired
	CustomerService customerService;
	
	private ArrayList<ErrorInfo> errorInforObj = null;
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullPointerException(final NullPointerException nullpoint, final HttpServletRequest servletRequest) {
		
		errorInforObj = getErrorInforObject("500", "NULLException",servletRequest);
		return new ResponseEntity<ArrayList<ErrorInfo>>(errorInforObj, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ArrayList<ErrorInfo> getErrorInforObject(String code, String message, HttpServletRequest servletRequest) {
		
		final ArrayList<ErrorInfo> listError = new ArrayList<ErrorInfo>();
		Map<String, String> detailMap = new HashMap<String, String>();
		ErrorInfo errorInfor = new ErrorInfo();
		errorInfor.setCode(code);
		detailMap.put(message, message);
		errorInfor.setDetail(detailMap);
		if(null!= servletRequest.getAttribute("customerId")) 
		{
			errorInfor.setCustomerId((String)servletRequest.getAttribute("customerId"));
		} 
		else
		{
			errorInfor.setCustomerId("Customer ID cannot be blank");
		}
		listError.add(errorInfor);
		return listError;
	}
	
	
	
	
	

}
