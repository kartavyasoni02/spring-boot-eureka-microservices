package com.demo.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.db.dto.DocumentDto;
import com.demo.db.mapper.DocumentMapper;
import com.demo.db.repository.DocumentRepository;
import com.demo.db.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private DocumentMapper documentMapper;

	@Override
	public void saveDocument(DocumentDto document) {
		documentRepository.save(documentMapper.mapToDomain(document));
	}

	@Override
	public DocumentDto getDocumentById(Integer id) {
		return documentMapper.mapToDto(documentRepository.findById(id).get());
	}

	@Override
	public List<DocumentDto> getDocuments() {
		return documentMapper.mapToDto(documentRepository.findAll());
	}

}
