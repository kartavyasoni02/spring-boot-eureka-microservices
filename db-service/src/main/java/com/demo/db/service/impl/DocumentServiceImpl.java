package com.demo.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.db.model.Document;
import com.demo.db.repository.DocumentRepository;
import com.demo.db.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public void saveDocument(Document document) {
		
	}

}
