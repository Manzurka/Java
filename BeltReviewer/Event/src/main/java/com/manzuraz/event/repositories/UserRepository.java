package com.manzuraz.event.repositories;

import org.springframework.stereotype.Repository;
import com.manzuraz.event.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByEmail(String email);
}
