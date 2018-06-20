package com.manzuraz.water.services;

import org.springframework.stereotype.Service;

import com.manzuraz.water.models.Review;
import com.manzuraz.water.repositories.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository rr;
	
	public ReviewService(ReviewRepository rr) {
		this.rr=rr;
	}
	
	public Review saveReview(Review r) {
		return rr.save(r);
	}
}
