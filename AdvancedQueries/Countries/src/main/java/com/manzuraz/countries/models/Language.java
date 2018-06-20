package com.manzuraz.countries.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;


@Entity
@Table(name = "languages")
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=3, max=3)
	private	String country_code;
	
	@Column
	@Size(min=2, max=30)
	private	String language;
	
	@Column
	private	Boolean is_official;
	
	@Column
	@Digits(integer = 4, fraction = 1)
	private	double percentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	public Language() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getIs_official() {
		return is_official;
	}

	public void setIs_official( Boolean is_official) {
		this.is_official = is_official;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country countries) {
		this.country = countries;
	}
	

}
