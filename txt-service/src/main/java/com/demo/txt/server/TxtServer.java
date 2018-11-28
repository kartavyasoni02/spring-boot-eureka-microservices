package com.demo.txt.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.demo.txt.txtservice.TxtServiceApplication;


/**
 * txt-service. Works as a microservice client, fetching data from the db-services
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(TxtServiceApplication.class)
public class TxtServer {

	/**application.properties
	 * URL uses the logical name of txt-service - upper or lower case,
	 * doesn't matter.
	 */

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for txt-service.properties or txt-service.yml
		System.setProperty("spring.config.name", "txt-service");
		SpringApplication.run(TxtServer.class, args);
	}


}
