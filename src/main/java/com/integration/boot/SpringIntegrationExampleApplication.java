package com.integration.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@ComponentScan(basePackages = {"com.integration.boot.*"})
@ImportResource("classpath:application_config.xml")
public class SpringIntegrationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationExampleApplication.class, args);
	}

}
