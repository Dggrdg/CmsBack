package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.JsonCheckerModel;

@Service
public class JsonCheckerService {

	public JsonCheckerModel checkJson(JsonCheckerModel jsonCheckerModel) {
		
		System.out.println("成功呼叫service");
		return null;
	}
}
