package com.sm.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sm.order.config.PropertiesConfig;
import com.sm.order.model.Order;
import com.sm.order.model.OrderDetails;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {
	@Autowired
	PropertiesConfig propertiesConfig;

	@GetMapping("/")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/order")
	public String getOrders() {
		log.info("<<<<OrderController>>>>>>>>>" + propertiesConfig.getDbUser());
		return "db name from k8s config map:{" + propertiesConfig.getDbName() + "}, user name from secret: {"
				+ propertiesConfig.getDbUser() + "}";
	}

	@GetMapping("/order/{customerId}")
	public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable String customerId) {
		return new ResponseEntity<>( buildOrder(customerId), HttpStatus.OK);
	}

	private List<Order> buildOrder(String customerId) {
		List<Order> orderList = new ArrayList<>();
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		orderDetailsList.add(
				OrderDetails.builder().orderDetailsId("zzzz-zzzz-zzzz").orderId("xxxx-xxxx-xxx").Item("Item").build());
		orderList.add(
				Order.builder().orderId("xxxx-xxxx-xxx").customerId(customerId).orderDetails(orderDetailsList).build());
		return orderList;
	}

}
