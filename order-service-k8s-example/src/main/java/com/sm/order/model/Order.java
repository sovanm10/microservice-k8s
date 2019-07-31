package com.sm.order.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"orderId",
	"customerId", 
	"orderDetails"
})
public class Order {
	private String orderId;
	private String customerId;
	private List<OrderDetails> orderDetails;

}
