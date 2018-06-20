package com.manzuraz.water.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manzuraz.water.models.Listing;
import com.manzuraz.water.models.Review;
import com.manzuraz.water.models.User;
import com.manzuraz.water.services.ListingService;
import com.manzuraz.water.services.ReviewService;
import com.manzuraz.water.services.UserService;

@Controller
public class ReviewController {
	private final ListingService ls;
	private final ReviewService rs;
	private final UserService us;
	public String[] numbers= new String[] {"1","2","3","4","5"};
	
	public ReviewController(ListingService ls, ReviewService rs,UserService us) {
		this.ls=ls;
		this.rs=rs;
		this.us=us;
	}
	
	@RequestMapping("listing/{id}/review")
	public String reviewPage(@ModelAttribute("r") Review review, Model m, @PathVariable("id")Long id) {
		Listing listing = ls.findById(id);
		m.addAttribute("listing", listing);
		m.addAttribute("numbers", numbers);
		return "review.jsp";
	}
	
	@PostMapping("listing/{id}/addreview")
	public String addReview(Principal p, Model m, @PathVariable("id")Long id,
			@Valid @ModelAttribute("r") Review review, BindingResult res) {
		User currentUser = us.findByEmail(p.getName());
		if(res.hasErrors()) {
			Listing listing = ls.findById(id);
			m.addAttribute("listing", listing);
			m.addAttribute("numbers", numbers);
			return "review.jsp";
		}else {
		rs.saveReview(review);
		review.setReviewer(currentUser);
		Listing l = ls.findById(id);
//		review.setListing(l);
		List<Review> reviews = l.getReviews();
		reviews.add(review);
		l.setReviews(reviews);
		ls.saveListing(l);
		rs.saveReview(review);
		return "redirect:/listing/"+l.getId();
		}
	}
}
