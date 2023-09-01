package com.schantz.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {
	
	@GetMapping("hello-world") //http get request
	public String HelloWorld() {
		return "Hellow World";
	}
}
