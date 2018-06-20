package com.manzuraz.license.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.manzuraz.license.models.License;
import com.manzuraz.license.models.Person;
import com.manzuraz.license.services.LicService;

@Controller
public class DriverLicenseController {
	private final LicService ls;
	public DriverLicenseController(LicService service) {
		this.ls = service;
	}
	
	@RequestMapping ("/show")
	public String show(Model m) {
		List<Person> list = ls.all_drivers();
		m.addAttribute("list", list);
		return "show.jsp";
	}
	
	@RequestMapping ("/persons/new")
	public String new_person(@ModelAttribute ("person") Person person) {
		return "newperson.jsp";
	}
	
	@RequestMapping ("/licenses/new")
	public String new_license(@ModelAttribute ("license") License license, Model model) {
		List<Person> list = ls.all_drivers();
		model.addAttribute("list", list );
		model.addAttribute("number", String.format("%06d", 1+ls.all_licenses().size()));
		return "newlicense.jsp";
	}
	
	@PostMapping ("/add")	
	public String addperson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		 if (result.hasErrors()) {
	    		return "newperson.jsp";
	        }else{
	        	ls.addperson(person);
	            return "redirect:/licenses/new";
	        }
	}
	
	@PostMapping ("/addlicense")	
	public String addperson(@Valid @ModelAttribute ("license") License license, BindingResult result) {
		 if (result.hasErrors()) {
	    		return "newlicense.jsp";
	        }else{
	        	ls.addlicense(license);
	            return "redirect:/licenses/new";
	        }
	}
	
	@RequestMapping ("/show/{id}")
	public String show(Model model,@PathVariable ("id") Long id ) {
		Person person = ls.findDriverbyId(id);
		model.addAttribute("person", person);
		return "show.jsp";
	}
}
