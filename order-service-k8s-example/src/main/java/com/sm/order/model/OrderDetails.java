package com.sm.order.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"orderDetailsId",
	"orderId", 
	"Item"
})
public class OrderDetails {
	private String orderDetailsId;
	private String orderId;
	private String Item;
}
