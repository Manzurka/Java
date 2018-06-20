package com.manzuraz.water.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.water.models.Listing;
import com.manzuraz.water.models.User;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
	List<Listing>findByHost(User host);
	List<Listing>findAll();
	List<Listing>findByAddressContaining(String term);
}
