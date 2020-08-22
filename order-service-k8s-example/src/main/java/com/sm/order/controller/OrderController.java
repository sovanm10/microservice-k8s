package com.sm.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sm.order.config.PropertiesConfig;
import com.sm.order.model.Customer;
import com.sm.order.model.Order;
import com.sm.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class OrderController {
	@Autowired
	private PropertiesConfig propertiesConfig;
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/order/db")
	public String getDBDetails() {
		log.info("OrderController::getDBDetails");
		return "db name {" + propertiesConfig.getDbName() + "},"
				+ " user name: {"+ propertiesConfig.getDbUser() + "}"
				+ " password: {"+ propertiesConfig.getDbPassword() + "}";
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<Order>> getOrders() {
		log.info("OrderController::getOrders");
		return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);

	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<List<Order>> getOrderByOrderId(@PathVariable String orderId) {
		log.info("OrderController::getOrdersByCustomer");
		return new ResponseEntity<>(orderService.getOrderByOrderId(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/order/{orderId}/customer")
	public ResponseEntity<Mono<Customer>> getCustomerByOredrId(@PathVariable String orderId) {
		log.info("OrderController::getCustomerByOredrId");
		return new ResponseEntity<>(orderService.getCustomerByOredrId(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/order/customer/{customerId}")
	public ResponseEntity<List<Order>> getOrderByCustomer(@PathVariable String customerId) {
		log.info("OrderController::getOrdersByCustomer");
		return new ResponseEntity<>(orderService.getOrderByCustomer(customerId), HttpStatus.OK);
	}
	
}
