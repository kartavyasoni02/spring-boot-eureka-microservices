package com.demo.json.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.demo.json.jsonservice.JsonServiceApplication;


/**
 * json-service. Works as a microservice client, fetching data from the db-services
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(JsonServiceApplication.class)
public class JsonServer {

	/**application.properties
	 * URL uses the logical name of json-service - upper or lower case,
	 * doesn't matter.
	 */

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for json-service.properties or json-service.yml
		System.setProperty("spring.config.name", "json-service");
		SpringApplication.run(JsonServer.class, args);
	}


}
