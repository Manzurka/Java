package com.manzuraz.event.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.manzuraz.event.models.Event;


@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event>findByState(String state);
	List<Event>findByStateNotIn(String state);
}
