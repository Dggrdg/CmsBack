package com.example.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonValidateService {

	public ResponseEntity<String> checkJson(MultipartFile file) throws IOException {

		String jsonString = new String(file.getBytes(), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();

		if (checkJsonFormat(objectMapper, jsonString)) {

			// 將JSON String轉換成Object
			Object jsonObject = objectMapper.readValue(jsonString, Object.class);
		} else {
			return ResponseEntity.status(500).body("JSON格式錯誤");
		}
		return ResponseEntity.status(200).body("JSON格式及內容正常");
	}

	// JSON格式檢核
	public boolean checkJsonFormat(ObjectMapper objectMapper, String jsonString) {

		try {
			objectMapper.readTree(jsonString);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
