package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.JsonValidateService;

@RestController
@RequestMapping("/cms")
@CrossOrigin(origins = "http://localhost:8090")
public class JsonValidateController {

	@Autowired
	private JsonValidateService jsonValidateService;

	@PostMapping("/jsonChecker")
	public ResponseEntity<?> checkJson(@RequestParam("file") MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("內容為空");
		} else {
			return jsonValidateService.checkJson(file);
		}
	}
}
