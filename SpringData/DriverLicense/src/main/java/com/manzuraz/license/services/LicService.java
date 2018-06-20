package com.manzuraz.license.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.manzuraz.license.models.License;
import com.manzuraz.license.models.Person;
import com.manzuraz.license.repositories.LicenseRepo;
import com.manzuraz.license.repositories.PersonRepo;


@Service
public class LicService {
	private final LicenseRepo licenserepo;
	private final PersonRepo personrepo;
	
	public LicService(LicenseRepo lr, PersonRepo pr){
	        this.licenserepo = lr;
	        this.personrepo = pr;
	    }
	
	public List<Person> all_drivers(){
		return personrepo.findAll();
	}
	
	public void addperson(Person p) {
		 personrepo.save(p);
	}
	
	public List<License> all_licenses(){
		return licenserepo.findAll();
	}
	
	public void addlicense(License lic) {
		licenserepo.save(lic);
	}
	
	public Person findDriverbyId(Long id) {
		return personrepo.findById(id).get();
	}
	
	
}
