package com.demo.db.resource;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.db.dto.DocumentDto;
import com.demo.db.mapper.DocumentMapper;
import com.demo.db.service.DocumentService;

@RestController
@RequestMapping("/rest/db/documents")
public class DbServiceResource {

	private static Logger logger = Logger.getLogger(DbServiceResource.class.getName());
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	public void saveDocument(@RequestBody DocumentDto documentDto){
		logger.info("Document Resource called");
		documentService.saveDocument(documentMapper.mapToDomain(documentDto));
	}
}
