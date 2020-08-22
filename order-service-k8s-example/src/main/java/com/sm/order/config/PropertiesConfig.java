package com.sm.order.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@ConfigurationProperties(prefix="db")
@Getter @Setter
public class PropertiesConfig {

	private String dbName;
	private String dbUser;
	private String dbPassword;
	@Value("${service.customer_service.host}")
	private String hostCustomerService;
	
	
}
