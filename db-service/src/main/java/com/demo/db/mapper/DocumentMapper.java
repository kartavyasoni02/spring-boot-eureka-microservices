package com.demo.db.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.db.dto.DocumentDto;
import com.demo.db.model.Document;

@Component
public class DocumentMapper {

	public DocumentDto mapToDto(Document document){
		DocumentDto documentDto  = new DocumentDto();
		documentDto.setId(document.getId());
		documentDto.setContent(document.getContent());
		documentDto.setFileType(document.getFileType());
		return documentDto;
	}
	
	public Document mapToDomain(DocumentDto documentDto){
		Document document  = new Document();
		document.setContent(documentDto.getContent());
		document.setFileType(documentDto.getFileType());
		return document;
	}

	public List<DocumentDto> mapToDto(List<Document> findAll) {
		List<DocumentDto> dtoList = new ArrayList<>();
		if(findAll!=null && !findAll.isEmpty()){
			for (Document document : findAll) {
				dtoList.add(mapToDto(document));
			}
		}
		return dtoList;
	}
}
