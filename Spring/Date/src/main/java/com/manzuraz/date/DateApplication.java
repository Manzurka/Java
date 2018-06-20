package com.manzuraz.date;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateApplication.class, args);
	}
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
	}
	
	@RequestMapping("/date")
    public String date(Model model) {
		Date d = new Date();
		model.addAttribute("date", d);
        return "date.jsp";
	}
	
	@RequestMapping("/time")
    public String time(Model model) {
		Date d = new Date();
		model.addAttribute("date", d);
        return "time.jsp";
	}
}
