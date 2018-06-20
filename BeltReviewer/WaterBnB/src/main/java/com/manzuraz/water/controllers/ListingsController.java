package com.manzuraz.water.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manzuraz.water.models.Listing;
import com.manzuraz.water.models.Review;
import com.manzuraz.water.models.User;
import com.manzuraz.water.services.ListingService;
import com.manzuraz.water.services.UserService;

@Controller
public class ListingsController {
	private final ListingService ls;
	private final UserService us;
	
	public ListingsController(ListingService ls, UserService us) {
		this.us=us;
		this.ls=ls;
	}
	@PostMapping("/search")
		public String searchresults(@RequestParam("term") String term, Model m) {
		List<Listing> listings = ls.findByAddressContaining(term);
		m.addAttribute("listings", listings);
		return "searchPage.jsp";
	}
	@RequestMapping("/dashboard")
		public String dashboard(Principal p, Model m, @ModelAttribute("listing") Listing listing){
		User currentUser = us.findByEmail(p.getName());
		String type = us.getType(currentUser);
		System.out.println(type);
		if(type != "Host"){
			List<Listing> listings = ls.findAll();
			if (listings == null) {
				m.addAttribute("listings", 1);
			}
			m.addAttribute("currentUser", currentUser);
			m.addAttribute("listings", listings);
			return "searchPage.jsp";
		}
			List<Listing> mylistings = ls.findByHost(currentUser);
			if (mylistings == null) {
				m.addAttribute("mylistings", 1);
			}
			m.addAttribute("mylistings", mylistings);
			return "dashboard.jsp";
}
	
	@PostMapping("/addListing")
		public String createListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult res, Model m, Principal p, HttpSession session) {
		User currentUser = us.findByEmail(p.getName());
		if(res.hasErrors()) {
			List<Listing> mylistings = ls.findByHost(currentUser);
			m.addAttribute("mylistings", mylistings);
		 	return "dashboard.jsp";
		} else {
			Listing l = ls.saveListing(listing);
//			List<Listing>listings = currentUser.getListings();
//			listings.add(l);
//			currentUser.setListings(listings);
//			us.saveUser(currentUser);
			l.setHost(currentUser);
			ls.saveListing(l);
			return "redirect:/dashboard";
		}
	
}

	@RequestMapping("/listing/{id}")
		public String showListing(Principal p, Model m,@PathVariable("id") Long id) {
		Listing l = ls.findById(id);
		m.addAttribute("listing", l);
		List<Review> reviews =l.getReviews();
		if(reviews.size() > 0) {
			int total=0;
			for (int i=0; i<reviews.size(); i++) {
				total+=Integer.parseInt(reviews.get(i).getRating());
			}
			double average =total/reviews.size();
			m.addAttribute("average", average);
			System.out.println(average);
		}
		
		return "show.jsp";
		
	}
	
	@RequestMapping("/listing/{id}/edit")
		public String editListing(Principal p, Model m, @ModelAttribute("listing") Listing l, @PathVariable("id") Long id) {
		return "edit.jsp";
	}
	
	@PostMapping("/listing/{id}/edit")
		public String updateListing(Principal p, Model m, @Valid @ModelAttribute("listing") Listing l, @PathVariable("id") Long id) {
		User currentUser = us.findByEmail(p.getName());
		ls.updateListing(l,currentUser);
		return "redirect:/dashboard";
	}

}
