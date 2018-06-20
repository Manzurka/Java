package com.manzuraz.dojosurvey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	@RequestMapping("/dojo")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(path="/result" , method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="dojolocation") String location,  @RequestParam(value="favoriteLanguage") String language, @RequestParam(value="comment") String comment ) {
		session.setAttribute("name", name); 
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "result.jsp";
	}
	

}
