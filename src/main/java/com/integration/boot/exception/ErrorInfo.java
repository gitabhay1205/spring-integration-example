package com.integration.boot.exception;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "detail"})
@Data
public class ErrorInfo {
	
	private String code;
	private Map<String, String> detail;
	private String customerId;
	
	

}
