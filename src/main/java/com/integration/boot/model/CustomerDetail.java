package com.integration.boot.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"customerId", "customerName","customerLocation"})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDetail {
	
	@NotNull(message="CustomerID cannot be null")
	private Integer customerId;
	private String customerName;
//    public Integer getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public String getCustomerLocation() {
//		return customerLocation;
//	}
//	public void setCustomerLocation(String customerLocation) {
//		this.customerLocation = customerLocation;
//	}
	private String customerLocation;	

}
