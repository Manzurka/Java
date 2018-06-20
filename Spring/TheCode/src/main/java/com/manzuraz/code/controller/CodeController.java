package com.manzuraz.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
		@RequestMapping(path = "/", method = RequestMethod.GET)
		public String index(@ModelAttribute("error") String error) {
		     return "main.jsp";
		}	
		
		@RequestMapping(path = "/", method = RequestMethod.POST)
		public String code(@RequestParam(value="code") String code, RedirectAttributes ra) {
			if (code.equals("bushido")) {
				return "secret.jsp";
			}
			ra.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
		
}
