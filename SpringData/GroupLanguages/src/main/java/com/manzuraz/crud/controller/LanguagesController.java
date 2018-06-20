package com.manzuraz.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manzuraz.crud.models.Language;
import com.manzuraz.crud.services.LanguageService;

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
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "languages.jsp";
	        }else{
	        	languageService.addLang(language);
	            return "redirect:/languages";
	        }
	    }
	
	@RequestMapping("/languages/show/{index}")
	public String showLanguages(Model model, @PathVariable("index") int index) {
		Language lang = languageService.findLangByIndex(index);
	    model.addAttribute("language", lang);
	    List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
	    
		return "show.jsp";
	}
	
	@RequestMapping("/languages/delete/{index}")
	public String deleteLanguages(@PathVariable("index") int index) {
		languageService.deleteLang(index);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/edit/{index}")
	public String editLanguages(Model model, @ModelAttribute("language") Language language, @PathVariable("index") int index) {
		Language lang = languageService.findLangByIndex(index);	
	    model.addAttribute("language", lang);
		return "edit.jsp";
	}
	
	@PostMapping(path="/languages/edit/{index}")
	public String updateLanguages(Model model, 
			@Valid @ModelAttribute("language") Language language, 
			BindingResult result, @PathVariable("index") int index) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLang(index, language);	
			return "redirect:/languages/show/{index}";
	}
	}

}
