package com.example.demo.dto;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonValidateDTO {

	private File jsonFile;

	private String message;

	public File getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
