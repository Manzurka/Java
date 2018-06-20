package com.manzuraz.water.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.water.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
