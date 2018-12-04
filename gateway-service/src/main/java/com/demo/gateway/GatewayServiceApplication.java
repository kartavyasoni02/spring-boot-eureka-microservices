package com.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.demo.gateway.configuration.CustomFallbackProvider;

@RibbonClients({@RibbonClient("json-service"),
	@RibbonClient("xml-service"),
	@RibbonClient("txt-service")})
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public CustomFallbackProvider xmlZuulFallbackProvider() {
		CustomFallbackProvider xmlZuulFallback = new CustomFallbackProvider();
		xmlZuulFallback.setRoute("xml");
		return xmlZuulFallback;
	}
	
	@Bean
	public CustomFallbackProvider jsonZuulFallbackProvider() {
		CustomFallbackProvider jsonZuulFallback = new CustomFallbackProvider();
		jsonZuulFallback.setRoute("json"); 
		return jsonZuulFallback;
	}
	
	@Bean
	public CustomFallbackProvider txtZuulFallbackProvider() {
		CustomFallbackProvider txtZuulFallback = new CustomFallbackProvider();
		txtZuulFallback.setRoute("txt");
		return txtZuulFallback;
	}
}
