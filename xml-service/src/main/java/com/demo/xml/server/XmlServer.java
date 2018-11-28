package com.demo.xml.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.demo.xml.xmlservice.XmlServiceApplication;


/**
 * xml-service. Works as a microservice client, fetching data from the db-services
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(XmlServiceApplication.class)
public class XmlServer {

	/**application.properties
	 * URL uses the logical name of xml-service - upper or lower case,
	 * doesn't matter.
	 */

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for xml-service.properties or xml-service.yml
		System.setProperty("spring.config.name", "xml-service");
		SpringApplication.run(XmlServer.class, args);
	}


}
