package com.integration.boot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.integration.boot.exception.ErrorInfo;
import com.integration.boot.model.CustomerDetail;

@Service
public class CustomerService {
	
	private ArrayList<ErrorInfo> errorInforObj = null;
	
	@ServiceActivator(inputChannel="processCustomerData")
	public ResponseEntity<?> getCustomerProcess(final Message<CustomerDetail> message) {
		 
		CustomerDetail details = new CustomerDetail();
		if(message.getPayload().getCustomerId()==null) {
			
			//throw new NullPointerException();
			errorInforObj = getErrorInforObject("500", "NULLException",message.getPayload());
			return new ResponseEntity<ArrayList<ErrorInfo>>(errorInforObj, HttpStatus.INTERNAL_SERVER_ERROR);
			//return new ResponseEntity<Object>("{ \"message\": \"" + "customerId is null"+"\"}", HttpStatus.BAD_REQUEST);
		} 
		else {
		details.setCustomerId(message.getPayload().getCustomerId());
		}
		details.setCustomerName(message.getPayload().getCustomerName().concat(" Agarwal"));
		details.setCustomerLocation(message.getPayload().getCustomerLocation().substring(0,3));
			
		return new ResponseEntity<Object>(details, HttpStatus.OK);
	}
	
	private ArrayList<ErrorInfo> getErrorInforObject(String code, String message, CustomerDetail servletRequest) {
		
		final ArrayList<ErrorInfo> listError = new ArrayList<ErrorInfo>();
		Map<String, String> detailMap = new HashMap<String, String>();
		ErrorInfo errorInfor = new ErrorInfo();
		errorInfor.setCode(code);
		detailMap.put(message, message);
		errorInfor.setDetail(detailMap);
		if(null!= servletRequest.getCustomerId()) 
		{
			errorInfor.setCustomerId(String.valueOf(servletRequest.getCustomerId()));
		} 
		else
		{
			errorInfor.setCustomerId("Customer ID cannot be blank");
		}
		listError.add(errorInfor);
		return listError;
	}

}
