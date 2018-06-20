package com.manzuraz.event.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manzuraz.event.models.Comment;
import com.manzuraz.event.models.Event;
import com.manzuraz.event.models.User;
import com.manzuraz.event.repositories.CommentRepository;
import com.manzuraz.event.repositories.EventRepository;


@Service
public class EventService {
	private final EventRepository er;
	private final CommentRepository cr;
	
	public EventService(EventRepository er, CommentRepository cr) {
		this.er=er;
		this.cr=cr;
	}
	
	public Event getById(Long id) {
		return er.findById(id).get();
	}
	
	public Event saveEvent(Event event) {
		return er.save(event);
	}
	
	public List<Event> inStateEvents(String state) {
		return er.findByState(state);
	}
	
	public List<Event> outOfStateEvents(String state) {
		return er.findByStateNotIn(state);
	}
	
	public void setEventHost(User host, Event event) {
	    event.setHost(host);
	    er.save(event);
	}
	
	public void deleteEvent(Long id) {
		er.deleteById(id);
	}
	
	public void updateEvent(Event event, User host) {
		event.setHost(host);
		er.save(event);
	}
	
	public Comment saveComment(Comment comment) {
		return cr.save(comment);	
	}
	
	public void linkCommentToEvent(Comment comment, Event event) {
		comment.setEvent(event);
		cr.save(comment);
	}
	
	public void linkCommentToUser(Comment comment, User commenter) {
		comment.setCommenter(commenter);
		cr.save(comment);
	}
	
	public void joinEventAsGuest(Event event, User guest) {
    	List<User> guests = event.getGuests();
    	guests.add(guest);
    	event.setGuests(guests);
    	er.save(event);
    }
	
	public void cancel(Event event, User guest) {
		List<User> guests = event.getGuests();
    	guests.remove(guest);
    	event.setGuests(guests);
    	er.save(event);
	}
}
