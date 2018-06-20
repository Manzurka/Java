package com.manzuraz.water.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.water.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}
