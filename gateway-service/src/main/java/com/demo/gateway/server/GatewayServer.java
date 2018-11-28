package com.demo.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import com.demo.gateway.configuration.RibbonConfiguration;
import com.demo.gateway.gatewayservice.GatewayServiceApplication;


/**
 * gateway-service. Works as a microservice client, fetching data from the respective service
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableZuulProxy
@EnableDiscoveryClient
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@Import(GatewayServiceApplication.class)
public class GatewayServer {

	/**application.properties
	 * URL uses the logical name of gateway-service - upper or lower case,
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
		System.setProperty("spring.config.name", "gateway-service");
		SpringApplication.run(GatewayServer.class, args);
	}


}
