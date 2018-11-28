package com.demo.server.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * All you need to run a Eureka registration server.
 * 
 * @author kartavya.soni
 */
@SpringBootApplication
@EnableEurekaServer
@ComponentScan(useDefaultFilters = false)
public class EurekaServer {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for eureka-service.properties or eureka-service.yml
		System.setProperty("spring.config.name", "eureka-service");

		SpringApplication.run(EurekaServer.class, args);
	}
}
