package com.mit.lab1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	private String value = "Hello, world!";
	
	
	@GetMapping("/get")
	public String getValue() {
		return value;
	}
}
