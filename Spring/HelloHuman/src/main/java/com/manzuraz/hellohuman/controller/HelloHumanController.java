package com.manzuraz.hellohuman.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", defaultValue = "Human") String name) {
		return "Hello " + name;
	}
	
}
