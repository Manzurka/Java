package com.manzuraz.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counters {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count != null) {
			session.setAttribute("count", count+1);
			return "index.jsp";
		} else {
			session.setAttribute("count", 1);
			return "index.jsp";
		}
		
	}
	@RequestMapping("/counter")
	public String count(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("time", count);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session, Model model) {
		session.setAttribute("count", 0);
		model.addAttribute("reset", "Count was reset");
		return "index.jsp";
	}


}
