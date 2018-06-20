package com.manzuraz.crud.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manzuraz.crud.models.Language;

@Service
public class LanguageService {
	
	private List<Language> languages = new ArrayList(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"), 
			new Language("Python", "Guido van Rossum", "3.6"), 
			new Language("Javascript", "Brendon Eich", "1.9.5.2.3")
			));
	

	public List<Language> allLanguages(){
		return languages;	
	}
	
	public void addLang(Language lang) {
        languages.add(lang);
	}

	public void updateLang(int index, Language language) {
	        if (index < languages.size()){
	        	languages.set(index, language);
	        }
	    }
	
	public Language findLangByIndex(int index) {
        if (index <  languages.size()){
            return languages.get(index);
        }else{
            return null;
        }
    }
	
	public void deleteLang(int id) {
        if (id < languages.size()){
            languages.remove(id);
        }
    }

}
