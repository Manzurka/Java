package com.manzuraz.countries.models;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=3, max=3)
	private	String code;
	
	@Column
	@Size(min=2, max=52)
	private	String name;
	
	@Column
	private String continent;
	
	@Column
	@Size(min=2, max=26)
	private	String region;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private	double surface_area;
	
	@Column
	@Digits(integer = 6, fraction = 0)
	private	short indep_year;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private	int population;
	
	@Column
	@Digits(integer = 3, fraction = 1)
	private	double life_expectancy;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private	double gnp;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private	double gnp_old;
	
	@Column
	@Size(min=2, max=45)
	private	String local_name;
	
	@Column
	@Size(min=2, max=45)
	private	String government_form;
	
	@Column
	@Size(min=2, max=60)
	private	String head_of_state;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private	int capital;
	
	@Column
	@Size(min=2, max=2)
	private	String code2; 
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Language> languages;
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<City> cities;
	
	public Country() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}

	public short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public double getGnp() {
		return gnp;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public double getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(double gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
}
