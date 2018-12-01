package com.demo.xml.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DocumentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "id cannot be null")
	private int id;

	@NotNull(message = "id cannot be null")
	private String content;
	
	@NotNull(message = "id cannot be null")
	private String fileType;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}

