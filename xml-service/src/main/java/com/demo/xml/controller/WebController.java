package com.demo.xml.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.xml.dto.DocumentDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class WebController {

	private Logger logger = Logger.getLogger(WebController.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "getAllCached", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
	@GetMapping("/rest/documents")
	public List<DocumentDto> document() {
		return restTemplate.getForObject("http://db-service/rest/v1/documents", List.class);
	}

	@HystrixCommand(fallbackMethod = "getData", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
	@GetMapping(path = "/rest/documents/{id}")
	public DocumentDto document(@PathVariable("id") Integer id) {
		logger.info("DocumentDto.findById");
		return restTemplate.getForObject("http://db-service/rest/v1/documents/"+id, DocumentDto.class);
	}

	public List<DocumentDto> getAllCached() {
		this.logger.info("documents.getAllCached()");
		this.logger.warning("documents cached result here");

		return new ArrayList<>();
	}

	public DocumentDto getData(Integer id) {
		this.logger.info("Articles.getAllCached()");
		this.logger.warning("Return cached result here");

		return new DocumentDto();
	}

	public void saveFileData(String content, String name) {
		DocumentDto document = new DocumentDto();
		document.setContent(content);
		document.setFileType(name);
		restTemplate.postForObject("http://db-service/rest/v1/documents", document, Void.class);
	}

}
