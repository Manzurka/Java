package com.manzuraz.dojosninjas.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.manzuraz.dojosninjas.models.Dojo;
import com.manzuraz.dojosninjas.models.Ninja;
import com.manzuraz.dojosninjas.services.DojoNinjaService;
import com.manzuraz.dojosninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	private final DojoNinjaService dns;
	private final NinjaService ns;
	
	public DojoNinjaController(DojoNinjaService DNS, NinjaService ns) {
		dns=DNS;
		this.ns=ns;
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
	    Page<Object[]> ninjas = ns.dojoninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String home(Model m) {
		List<Dojo> dojos = dns.all_dojos();
		m.addAttribute("dojoslist", dojos);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo d) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo d, BindingResult res) {
		if(res.hasErrors()) {
			return "newdojo.jsp";
		}
		dns.addDojo(d);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model m, @ModelAttribute("ninja") Ninja n) {
		List<Dojo> dojos = dns.all_dojos();
		m.addAttribute("dojoslist", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja n, BindingResult res, Model m) {
		if(res.hasErrors()) {
			List<Dojo> dojos = dns.all_dojos();
			m.addAttribute("dojoslist", dojos);
			return "newninja.jsp";
		}
		dns.addNinja(n);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(Model m, @PathVariable("id") Long id) {
		Dojo d = dns.findDojobyId(id);
		m.addAttribute("dojo", d);
		return "showdojo.jsp";
	}
	
}
