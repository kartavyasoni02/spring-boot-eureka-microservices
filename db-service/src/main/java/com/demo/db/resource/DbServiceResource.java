package com.demo.db.resource;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.db.dto.DocumentDto;
import com.demo.db.service.DocumentService;

@RestController
public class DbServiceResource {

	private static Logger logger = Logger.getLogger(DbServiceResource.class.getName());
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/rest/v1/documents")
	public void saveDocument(@RequestBody DocumentDto documentDto){
		logger.info("Document Resource called");
		documentService.saveDocument(documentDto);
	}
	
	
	@GetMapping("/rest/v1/documents/{id}")
	public DocumentDto getDocumentById(@PathVariable("id") Integer id){
		logger.info("Get DocumentById called");
		return documentService.getDocumentById(id);
	}
	
	@GetMapping("/rest/v1/documents")
	public List<DocumentDto> getDocuments(){
		logger.info("Document Resource called");
		return documentService.getDocuments();
	}
}
