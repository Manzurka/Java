package com.manzuraz.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.project.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea,Long>{
	List<Idea> findAll();
	
	@Query("SELECT i FROM Idea i ORDER BY i.likedUsers.size ASC")
	List<Idea> sortBylikedUsersNumAsc();
	
	@Query("SELECT i FROM Idea i ORDER BY i.likedUsers.size DESC")
	List<Idea> sortBylikedUsersNumDesc();
	
}
