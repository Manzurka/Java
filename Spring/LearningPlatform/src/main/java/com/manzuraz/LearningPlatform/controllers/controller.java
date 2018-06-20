package com.manzuraz.LearningPlatform.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	
	@RequestMapping(value="/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping(value="/m/{chapter}/0553/{lessonNumber}")
	public String lesson(@PathVariable String chapter, @PathVariable String lessonNumber) {
					return "lesson.jsp";
	}
	
	@RequestMapping(value="/m/{chapter}/0483/{assignmentNumber}")
	public String assignment(@PathVariable String chapter, @PathVariable String assignmentNumber) {
					return "assignment.jsp";
	}
}
