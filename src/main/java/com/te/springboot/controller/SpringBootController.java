package com.te.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping("/")
	public String getFirstData() {
	return "welcome to TechnoElevate";	
	}
}
