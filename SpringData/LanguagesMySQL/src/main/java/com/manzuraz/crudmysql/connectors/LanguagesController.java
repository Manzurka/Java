package com.manzuraz.crudmysql.connectors;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.manzuraz.crudmysql.models.Language;
import com.manzuraz.crudmysql.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String languages(Model model,@ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages.jsp";
	}
	
	@PostMapping("/languages/new")
	public String createLanguage(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	    		model.addAttribute("languages", languageService.allLanguages());
	            return "languages.jsp";
	        }else{
	        	languageService.addLang(language);
	            return "redirect:/languages";
	        }
	    }
	
	@RequestMapping("/languages/show/{id}")
	public String showLanguages(Model model, @PathVariable("id") Long id) {
		Language lang = languageService.findLangByIndex(id);
	    model.addAttribute("language",lang);
		return "show.jsp";
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguages(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguages(Model model, @ModelAttribute("language") Language language, @PathVariable("id") Long id) {
	    model.addAttribute("language", languageService.findLangByIndex(id));
		return "edit.jsp";
	}
	
	@PostMapping(path="/languages/edit/{id}")
	public String updateLanguages(Model model,@Valid @ModelAttribute("language") Language language, 
			BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLang( language);	
			return "redirect:/languages/show/{id}";
	}
	}

}
