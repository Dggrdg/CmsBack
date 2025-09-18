package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.JsonCheckerModel;
import com.example.demo.service.JsonCheckerService;

@Controller
public class JsonCheckerController {

	private JsonCheckerService jsonCheckerService;

	@PostMapping("/jsonChecker")
	public JsonCheckerModel checkJson(JsonCheckerModel jsonCheckerModel) {
		System.out.println("成功呼叫後端");

		jsonCheckerService.checkJson(jsonCheckerModel);
		return null;
	}
}
