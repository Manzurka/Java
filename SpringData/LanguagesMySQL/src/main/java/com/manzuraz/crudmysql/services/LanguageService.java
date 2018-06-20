package com.manzuraz.crudmysql.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manzuraz.crudmysql.models.Language;
import com.manzuraz.crudmysql.repositories.LanguageRepository;

@Service
public class  LanguageService  {
	private List<Language> languages = new ArrayList<Language>();
	
	private LanguageRepository languageRepository;
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    
	public List<Language> allLanguages(){
		return languageRepository.findAll();	
	}
	
	public void addLang(Language lang) {
        languageRepository.save(lang);
	}

	public void updateLang(Language language) {
		languageRepository.save(language);
	}
	
	public  Language findLangByIndex(Long id) {
          return languageRepository.findById(id).get();
    }
	
	public void deleteLang(Long id) {
		if (id <  languageRepository.count()) {
			languageRepository.deleteById(id);
		}
    }

}
