package com.sm.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sm.order.config.PropertiesConfig;
import com.sm.order.model.Customer;
import com.sm.order.model.Order;
import com.sm.order.model.OrderDetails;

import reactor.core.publisher.Mono;

@Service
public class OrderService {
	@Autowired
	private PropertiesConfig propertiesConfig;

	public List<Order> getOrderByOrderId(final String orderId) {
		List<Order> orderList = new ArrayList<>();
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		orderDetailsList
				.add(OrderDetails.builder()
						.orderDetailsId("zzzz-zzzz-zzzz")
						.orderId(orderId).item("Item")
						.build());
		orderList.add(Order.builder()
				.orderId(orderId)
				.customerId("CX")
				.orderDetails(orderDetailsList)
				.build());
		return orderList;
	}

	public List<Order> getOrders() {
		List<Order> orderList = new ArrayList<>();
		orderList.add(Order.builder()
				.orderId("111111")
				.customerId("C1")
				.build());
		orderList.add(Order.builder()
				.orderId("222222")
				.customerId("C2")
				.build());
		return orderList;
	}

	public List<Order> getOrderByCustomer(String customerId) {
		List<Order> orderList = new ArrayList<>();
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		orderDetailsList
				.add(OrderDetails.builder()
						.orderDetailsId("zzzz-zzzz-zzzz")
						.orderId("111111")
						.item("Item")
						.build());
		orderList.add(Order.builder()
				.orderId("111111")
				.customerId(customerId)
				.orderDetails(orderDetailsList)
				.build());
		return orderList;
	}

	public Mono<Customer> getCustomerByOredrId(final String orderId) {
		String customerId = "C1";
		return WebClient.create()
				.get()
				.uri(propertiesConfig.getHostCustomerService() + "/v1/customer/" + customerId)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Customer.class);

	}

}
