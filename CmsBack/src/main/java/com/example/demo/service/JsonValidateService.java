package com.example.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

@Service
public class JsonValidateService {

	private JsonSchema chargingRecSchema;
	
	public JsonValidateService(JsonSchema chargingRecSchema) {
        this.chargingRecSchema = chargingRecSchema;
    }

	public ResponseEntity<String> checkJson(MultipartFile file) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String jsonString = new String(file.getBytes(), StandardCharsets.UTF_8);
			JsonNode jsonNode = objectMapper.readTree(jsonString);

			Set<ValidationMessage> errors = chargingRecSchema.validate(jsonNode);

			if (errors.isEmpty()) {
				return ResponseEntity.ok("JSON 格式正確");
			} else {
				StringBuilder sb = new StringBuilder("JSON 格式錯誤:\n");
				errors.forEach(err -> sb.append(err.getMessage()).append("\n"));
				return ResponseEntity.badRequest().body(sb.toString());
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("伺服器錯誤: " + e.getMessage());
		}

	}
}
