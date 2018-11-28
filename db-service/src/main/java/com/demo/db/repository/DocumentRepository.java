package com.demo.db.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.db.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{
	
	@SuppressWarnings("unchecked")
	Document save(Document document);

}
