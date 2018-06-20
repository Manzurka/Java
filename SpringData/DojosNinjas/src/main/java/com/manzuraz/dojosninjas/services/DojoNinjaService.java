package com.manzuraz.dojosninjas.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.manzuraz.dojosninjas.models.Dojo;
import com.manzuraz.dojosninjas.models.Ninja;
import com.manzuraz.dojosninjas.repositories.DojoRepo;
import com.manzuraz.dojosninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaService {
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public DojoNinjaService(DojoRepo dr, NinjaRepo nr) {
		this.dojoRepo=dr;
		this.ninjaRepo=nr;
	}
	
	public List<Dojo> all_dojos(){
		return dojoRepo.findAll();
	}
	
	public List<Ninja> all_ninjas() {
		return ninjaRepo.findAll();
		
	}
	
	public void addDojo(Dojo dojo){
		dojoRepo.save(dojo);
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public Dojo findDojobyId(Long id){
		return dojoRepo.findById(id).get();
	}
}
