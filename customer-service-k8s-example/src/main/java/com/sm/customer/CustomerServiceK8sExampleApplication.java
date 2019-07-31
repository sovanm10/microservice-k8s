package com.sm.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceK8sExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceK8sExampleApplication.class, args);
	}

}
