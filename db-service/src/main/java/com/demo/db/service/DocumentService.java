package com.demo.db.service;

import java.util.List;

import com.demo.db.dto.DocumentDto;

public interface DocumentService {
	
	public void saveDocument(DocumentDto document);

	public DocumentDto getDocumentById(Integer id);

	public List<DocumentDto> getDocuments();

}
