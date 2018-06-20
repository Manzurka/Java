package com.manzuraz.countries.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.manzuraz.countries.repositories.CityRepository;
import com.manzuraz.countries.repositories.CountryRepository;
import com.manzuraz.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	private final CityRepository cr;
	private final CountryRepository cnr;
	private final LanguageRepository lr;
	
	public ApiService(CityRepository cr, CountryRepository cnr,  LanguageRepository lr) {
		this.cr=cr;
		this.cnr=cnr;
		this.lr=lr;
	}
	public List<Object[]> findSloveneSpeakingCountries() {
		return cnr.findSloveneSpeakingCountries();
	}
	public List<Object[]> countCities() {
		return cnr.countCities();
	}
	public List<Object[]> citiesInMexico() {
		return cr.citiesInMexico();
	}
	public List<Object[]> languagesByPercentage(){
		return lr.languagesByPercentage();
	}
	public List<Object[]> countriesBySurfaceArea(){
		return cnr.countriesBySurfaceArea();
	}
	public List<Object[]> countriesWithConstMonarchy(){
		return cnr.countriesWithConstMonarchy();
	}
	public List<Object[]> findCitiesInArgentina() {
		return cr.findCitiesInArgentina();
	}
	public List<Object[]> countriesInEachRegion() {
		return cnr.countriesInEachRegion();
	}
	
}
