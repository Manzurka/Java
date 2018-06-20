package com.manzuraz.project.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manzuraz.project.models.Idea;
import com.manzuraz.project.models.User;
import com.manzuraz.project.services.IdeaService;
import com.manzuraz.project.services.UserService;

@Controller
public class IdeasController {
	private final IdeaService is;
	private final UserService us;
	
	public IdeasController(IdeaService is, UserService us) {
		this.is=is;
		this.us=us;
	}
	
	@RequestMapping("/ideas") 
		public String welcome(Principal principal, Model model){
		User currentUser= us.findByEmail(principal.getName());
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("ideas", is.all_ideas());
		return "dashboard.jsp";
	}
		
	@RequestMapping("/ideas/{id}/like") 
		public String like(Model model, Principal principal, @PathVariable("id") Long id) {
		User currentUser= us.findByEmail(principal.getName());
		Idea idea = is.findById(id);
		List<User> users = idea.getLikedUsers();
		if(!users.contains(currentUser)) {
			is.addtoLikedUsers(currentUser, idea);
		}
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("ideas", is.all_ideas());
			
		return "dashboard.jsp";
	}
	
	@RequestMapping("/ideas/{id}/unlike") 
		public String unlike(Model model, Principal principal, @PathVariable("id") Long id) {
		User currentUser= us.findByEmail(principal.getName());
		Idea idea = is.findById(id);
		List<User> users = idea.getLikedUsers();
		if(users.contains(currentUser)) {
			is.removeFromLikedUsers(currentUser, idea);
		}
			model.addAttribute("currentUser", currentUser);
			model.addAttribute("ideas", is.all_ideas());
			
		return "dashboard.jsp";
	}
	
	@RequestMapping("/ideas/new") 
		public String newIdea(@ModelAttribute("idea") Idea idea) {
		return "newIdea.jsp";
	}
	
	@PostMapping("/ideas/new/create") 
		public String createIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		if(result.hasErrors()) {
			return "newIdea.jsp";
		}
			idea.setCreator(currentUser);
			is.saveIdea(idea);
			return "redirect:/ideas/"+idea.getId();
	}
	
	@RequestMapping("/ideas/{id}")
		public String showIdea(Principal principal, @PathVariable("id") Long id, Model model) {
		model.addAttribute("idea", is.findById(id));
		return "show.jsp";
	}
	
	@RequestMapping("/ideas/{id}/edit")
		public String editIdea(@ModelAttribute("idea") Idea idea, Model model, @PathVariable("id") Long id, Principal principal) {
		User currentUser = us.findByEmail(principal.getName());
		if(currentUser != is.findById(id).getCreator()) {
			return "redirect:/ideas";
		}
		model.addAttribute("idea", is.findById(id));
		return "edit.jsp";
	}
	
	@PostMapping("/ideas/{id}/update") 
		public String updateIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, Principal principal, @PathVariable("id") Long id) {
		User currentUser = us.findByEmail(principal.getName());
		if(result.hasErrors()) {
			model.addAttribute("idea", is.findById(id));
			return "edit.jsp";
		}
		idea.setCreator(currentUser);
		is.saveIdea(idea);
		return "redirect:/ideas/"+idea.getId();
	}
	
	@RequestMapping("/ideas/{id}/delete") 
		public String deleteIdea(Model model, Principal principal, @PathVariable("id") Long id) {
		User currentUser = us.findByEmail(principal.getName());
		if(currentUser != is.findById(id).getCreator()) {
			return "redirect:/ideas";
		}
			is.delete(id);
			return "redirect:/ideas";
	}
	
	@RequestMapping("/ideas/sortByLowLikes")
		public String sortByLowLikes(Model model, Principal principal) {
		User currentUser= us.findByEmail(principal.getName());
		List<Idea> ideas=is.lowlikes();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("ideas", ideas);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/ideas/sortByHighLikes")
		public String sortByHighLikes(Model model, Principal principal) {
		User currentUser= us.findByEmail(principal.getName());
		List<Idea> ideas=is.highlikes();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("ideas", ideas);
		return "dashboard.jsp";
	}
}
