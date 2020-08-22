package com.sm.customer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerId", "customerNm", "mobile", "email" })
public class Customer {
	private String customerId;
	private String customerNm;
	private String mobile;
	private String email;
}
