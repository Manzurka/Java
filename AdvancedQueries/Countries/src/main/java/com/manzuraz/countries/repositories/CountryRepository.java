package com.manzuraz.countries.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.manzuraz.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findAll();
	
	@Query("SELECT l.language, l.percentage, c.name FROM Country AS c JOIN c.languages AS l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
    List<Object[]> findSloveneSpeakingCountries(); //1 Countries that speak Slovene by language percentage in descending order.
    
    @Query("SELECT c.name, c.region, COUNT(city) FROM Country AS c JOIN c.cities AS city GROUP BY c.name ORDER BY COUNT(city) DESC")
    List<Object[]> countCities(); //2  Total number of cities for each country.
    
    @Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 and c.population > 100000")
	List<Object[]> countriesBySurfaceArea(); //5 Countries with Surface Area below 501 and Population greater than 100,000.
	
	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Object[]> countriesWithConstMonarchy(); //6 Sort countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years.
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> countriesInEachRegion();// 8 Summarizing the number of countries in each region.
} 
