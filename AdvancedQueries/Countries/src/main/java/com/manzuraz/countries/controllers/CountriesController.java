package com.manzuraz.countries.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.manzuraz.countries.services.ApiService;
import com.manzuraz.countries.models.City;

@Controller
public class CountriesController {
	private final ApiService as;
	
	public CountriesController(ApiService as) {
		this.as=as;
	}
	
	@RequestMapping("/")
	public String index(Model m) {
		List<Object[]> table1 = as.findSloveneSpeakingCountries();
		ArrayList<String>sloveneCountries = new ArrayList<String>();
		for(Object[] row : table1) {
			String country = row[2]+" "+row[1];
			sloveneCountries.add(country);
		}
		
		m.addAttribute("sloveneCountries", sloveneCountries);
		
		List<Object[]> table2 = as.countCities();
		ArrayList<String>citiesByCountries = new ArrayList<String>();
		for(Object[] row : table2) {
			String citiesByCountry = row[0]+" "+row[2];
			citiesByCountries.add(citiesByCountry);
		}
		
		m.addAttribute("citiesByCountries", citiesByCountries);
		
		List<Object[]> table3 = as.citiesInMexico();
		ArrayList<String>citiesInMexico = new ArrayList<String>();
		for(Object[] row : table3) {
			String city = row[1]+" ";
			citiesInMexico.add(city);
		}
		
		m.addAttribute("citiesInMexico", citiesInMexico); 
		
		List<Object[]> table4 = as.languagesByPercentage();
		ArrayList<String>languages = new ArrayList<String>();
		for(Object[] row : table4) {
			String lang = row[1]+" "+row[0]+" "+row[2];
			languages.add(lang);
		}
	
		m.addAttribute("languages", languages);
		
		List<Object[]> table5 = as.countriesBySurfaceArea();
		ArrayList<String>countries = new ArrayList<String>();
		for(Object[] row : table5) {
			String c = row[0]+" "+row[1];
			countries.add(c);
		}
		
		m.addAttribute("countries", countries);
		
		List<Object[]> table6 = as.countriesWithConstMonarchy();
		ArrayList<String>monarchyCountries = new ArrayList<String>();
		for(Object[] row : table6) {
			String mc = row[0]+"";
			monarchyCountries.add(mc);
		}
		
		m.addAttribute("monarchyCountries", monarchyCountries);
		
		List<Object[]> table7 = as.findCitiesInArgentina();
		ArrayList<String> citiesInArgentina = new ArrayList<String>();
		for(Object[] row : table7) {
			String a = row[0]+" "+row[2];
			citiesInArgentina.add(a);
		}
		
		m.addAttribute("citiesInArgentina", citiesInArgentina);
		
		List<Object[]> table8 = as.countriesInEachRegion();
		ArrayList<String>regions = new ArrayList<String>();
		for(Object[] row : table8) {
			String num = row[0]+" "+row[1];
			regions.add(num);
		}
		
		m.addAttribute("regions", regions);
		
		return "index.jsp";
	}
}
