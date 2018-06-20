package com.manzuraz.lookify.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.manzuraz.lookify.models.Song;
import com.manzuraz.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {	
	
	private final LookifyRepository lookifyRepository;
    public LookifyService(LookifyRepository lookifyRepository){
        this.lookifyRepository = lookifyRepository;
    }
    
    public List<Song> all_songs(){
		return lookifyRepository.findAll();
    }
    
    public List<Song> BySearchKeyword(String searchterm) {
    	return lookifyRepository.findByArtistContaining(searchterm);
    }
    
	public List<Song> top_songs(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	public void addsong(Song song) {
        lookifyRepository.save(song);
	}
	public Song findById(Long id) {
		return lookifyRepository.findById(id).get();
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
    }
}
