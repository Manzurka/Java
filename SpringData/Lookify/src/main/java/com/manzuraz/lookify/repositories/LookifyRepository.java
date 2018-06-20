package com.manzuraz.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.manzuraz.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtistContaining(String searchterm);
	List<Song> findTop10ByOrderByRatingDesc();
}
