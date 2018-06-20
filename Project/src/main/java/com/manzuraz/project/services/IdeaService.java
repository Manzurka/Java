package com.manzuraz.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manzuraz.project.models.Idea;
import com.manzuraz.project.models.User;
import com.manzuraz.project.repositories.IdeaRepository;

@Service
public class IdeaService {
	private final IdeaRepository ideaRepo;
	
	public IdeaService(IdeaRepository ir) {
		this.ideaRepo=ir;
	}
	public List<Idea> all_ideas(){
		return ideaRepo.findAll();
	}
	
	public Idea findById(Long id) {
		return ideaRepo.findById(id).get();
	}
	
	public List<Idea> lowlikes(){
		return ideaRepo.sortBylikedUsersNumAsc();
	}
	
	public List<Idea> highlikes(){
		return ideaRepo.sortBylikedUsersNumDesc();
	}
	
	public void addtoLikedUsers(User user, Idea idea) {
		List<User> list = idea.getLikedUsers();
		list.add(user);
		idea.setLikedUsers(list);
		ideaRepo.save(idea);
	}

	public void removeFromLikedUsers(User user, Idea idea) {
		List<User> list = idea.getLikedUsers();
		list.remove(user);
		idea.setLikedUsers(list);
		ideaRepo.save(idea);
	}
	
	public void saveIdea(Idea idea) {
		ideaRepo.save(idea);
	}
	
	public void delete(Long id) {
		ideaRepo.deleteById(id);
	}
	
}
