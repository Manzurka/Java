package com.manzuraz.water.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.manzuraz.water.models.Listing;
import com.manzuraz.water.models.User;
import com.manzuraz.water.repositories.ListingRepository;
import com.manzuraz.water.repositories.UserRepository;

@Service
public class ListingService {
	private ListingRepository lr;
	private UserRepository ur;
	
	public ListingService(ListingRepository lr, UserRepository ur) {
		this.lr=lr;
		this.ur=ur;
	}
	public List<Listing> findAll(){
		return lr.findAll();
	}
	public Listing findById(Long id) {
		return lr.findById(id).get();
	}
	
	public List<Listing> findByAddressContaining(String term){
		return lr.findByAddressContaining(term);
	}
	
	public List<Listing> findByHost(User host){
		return lr.findByHost(host);
	}
	
	public Listing saveListing(Listing l) {
		return lr.save(l);
	}
	
	public void updateListing(Listing l, User u) {
		l.setHost(u);
		lr.save(l);
	}
}
