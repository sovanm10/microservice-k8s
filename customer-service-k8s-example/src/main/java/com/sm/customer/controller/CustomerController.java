package com.sm.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sm.customer.client.OrderClient;
import com.sm.customer.model.Customer;
import com.sm.customer.model.Order;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	@Autowired
	OrderClient orderClient;

	@GetMapping("/")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/customer")
	public String getCustomer() {
		log.info("CustomerController::getCustomer");
		return "Hi, I am from Customer Service. Do you need any help?)";
	}

	@GetMapping("/customer/{customerId}/order")
	public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable String customerId) {
		log.info("CustomerController::getOrdersByCustomer");
		return new ResponseEntity<>(orderClient.getOrdersByCustomer(customerId), HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerByOredrId(@PathVariable String customerId) {
		log.info("OrderController::getCustomerByOredrId");
		return new ResponseEntity<>(Customer.builder().customerId(customerId).customerNm("CN-NAME").mobile("xxxxxxxx90")
				.email("xxxxxxxx1@gmail.com").build(), HttpStatus.OK);
	}
}
