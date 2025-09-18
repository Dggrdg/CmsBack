package com.example.demo.model;

import java.io.File;

public class JsonCheckerModel {

	private File jsonFile;

	private String[] message;

	public File getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(File jsonFile) {
		this.jsonFile = jsonFile;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

}
