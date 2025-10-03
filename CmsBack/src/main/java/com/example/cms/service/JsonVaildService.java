package com.example.cms.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

@Service
public class JsonVaildService {

	@Autowired
	private JsonSchema jsonSchema;

	public ResponseEntity<?> jsonVaild(MultipartFile file) throws IOException {

		try {
			String jsonFile = new String(file.getBytes(), StandardCharsets.UTF_8);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(jsonFile);
			Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

			if (errors.isEmpty()) {
				return ResponseEntity.status(200).body("驗證正常");
			} else {
				return ResponseEntity.badRequest().body(errors);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}

}
