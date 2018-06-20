package com.manzuraz.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.manzuraz.countries.models.City;


@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	 @Query("SELECT city.population, city.name, c.name FROM City city JOIN city.country c WHERE c.name = 'Mexico' AND city.population > 500000 ORDER BY city.population DESC")
	 List<Object[]> citiesInMexico(); //3 Cities in Mexico with population greater than 500,000
	 
	 @Query("SELECT city.name, city.district, city.population, c.name FROM City city JOIN city.country c WHERE c.name = 'Argentina' AND city.district = 'Buenos Aires' AND city.population > 500000")
	 List<Object[]> findCitiesInArgentina(); //7 All the cities of Argentina inside the Buenos Aires district with the population greater than 500, 000.
	 
} 
