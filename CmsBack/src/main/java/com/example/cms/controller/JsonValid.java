package com.example.cms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.cms.service.JsonVaildService;

@Controller
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/cms")
public class JsonValid {

	@Autowired
	JsonVaildService jsonVaildService;

	@PostMapping("/jsonValid")
	public ResponseEntity<?> jsonVaild(MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("檔案為空");
		} else {
			return jsonVaildService.jsonVaild(file);
		}
	}

}
