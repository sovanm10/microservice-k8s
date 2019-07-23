package com.sm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	
	@GetMapping("/")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public String getOrders() {
		log.info("<<<<CustomerController>>>>>>>>>");
		return "Hi, I am from Customer Service. Do you need any help?";
	}

}
