package com.manzuraz.event.controllers;

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

import com.manzuraz.event.models.Comment;
import com.manzuraz.event.models.Event;
import com.manzuraz.event.models.User;
import com.manzuraz.event.services.EventService;
import com.manzuraz.event.services.UserService;

@Controller
public class EventsController {
	private final EventService es;
	private final UserService us;
	private String[] listOf50states;
	
	public EventsController(EventService eventService, UserService us) {
		this.es = eventService;
		this.us = us;
		this.listOf50states=new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	}
	
	@RequestMapping("/events") 
		public String dashboard(Principal principal, @ModelAttribute("event") Event event, Model m) {
		String email = principal.getName();
		User currentUser= us.findByEmail(email);
	    String state = currentUser.getState();
		List<Event> instateevents = es.inStateEvents(state);
		List<Event> outofstate = es.outOfStateEvents(state);
		
		if ( instateevents == null) {
			m.addAttribute("inStatePage", 1);
		}
		if ( outofstate == null) {
			m.addAttribute("outOfStateEvents", 1);
		} else {
			m.addAttribute("inStateEvents", instateevents);
		}
		m.addAttribute("outOfStateEvents", outofstate);
		m.addAttribute("currentUser", currentUser);
		m.addAttribute("listOfstates", listOf50states);
		return "events.jsp";
	}

	@PostMapping("/addEvent") 
		public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Principal principal, Model model, HttpSession session){
	
		if (result.hasErrors()) {		
			System.out.println(event.getEventDate());
			User currentUser= us.findByEmail(principal.getName());
	        model.addAttribute("currentUser", currentUser);
			String state = currentUser.getState();
			model.addAttribute("inStateEvents", es.inStateEvents(state));
			model.addAttribute("inStateEvents", es.outOfStateEvents(state));
			model.addAttribute("listOfstates", listOf50states);
			return "events.jsp";
		}
		
		Event e = es.saveEvent(event);
		User host = us.findByEmail(principal.getName());
		es.setEventHost(host,e);
		return "redirect:/events";
	}

	@RequestMapping("/events/{id}")
		public String showEvent(@ModelAttribute("comment") Comment comment, @PathVariable("id") Long id, Model m){
		m.addAttribute("event", es.getById(id));
		return "showEvent.jsp";
	}
	
	@RequestMapping("/events/{id}/delete")
		public String addEvent(@PathVariable("id") Long id){
		es.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
		public String editEvent(@ModelAttribute("event") Event event, @PathVariable("id") Long id, Principal principal, Model m){
		User currentUser = us.findByEmail(principal.getName());
		m.addAttribute(currentUser);
		m.addAttribute("listOfstates", listOf50states);
		return "editEvent.jsp";
	}
	
	@PostMapping("/events/{id}/edit")
		public String updateEvent(Principal p,@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result){
		if (result.hasErrors()) {
			return "editEvent.jsp";
		}
		User host = us.findByEmail(p.getName());
		es.updateEvent(event, host);
		return "redirect:/events";
	}
	
	@PostMapping("/events/{id}/addComment")
		public String  createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult res, @PathVariable("id") Long id, Principal principal){
		if (res.hasErrors()) {
			return "redirect:/events/{id}";
		}
		Comment c = es.saveComment(comment);
		Event event = es.getById(id);
		es.linkCommentToEvent(c, event);
		String email = principal.getName();
		User commenter = us.findByEmail(email);
		es.linkCommentToUser(c, commenter);
		return "redirect:/events/"+event.getId();
	}
	
	@RequestMapping("/events/{id}/addguest/{userid}")
		public String addGuest(@PathVariable("userid") Long userid, @PathVariable("id") Long id, Principal p){
		User guest = us.findById(userid);
		Event event = es.getById(id);
		es.joinEventAsGuest(event,guest);
		return "redirect:/events";
	}
	
	@RequestMapping("/cancel/{userid}/{eventid}")
		public String cancel(@PathVariable("userid") Long userid, @PathVariable("eventid") Long eventid){
		User guest = us.findById(userid);
		Event event = es.getById(eventid);
		es.cancel(event, guest);
		return "redirect:/events";
	}
}
