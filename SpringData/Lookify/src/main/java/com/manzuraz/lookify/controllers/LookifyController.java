package com.manzuraz.lookify.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.manzuraz.lookify.models.Song;
import com.manzuraz.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
	this.lookifyService = lookifyService;
	}

	@RequestMapping("/") //home
	public String root() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard") //display all songs
	public String dashboard(Model m) {
		List<Song> songs = lookifyService.all_songs();
		m.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/search") //search by artist name
	public String search(Model m, @RequestParam ("search") String searchterm) {
		List<Song> results = lookifyService.BySearchKeyword(searchterm);
		m.addAttribute("foundsongs", results);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/search/topTen") //display top10 songs
	public String top_songs(Model m) {
		List<Song> topsongs = lookifyService.top_songs();
		m.addAttribute("topsongs", topsongs);
		return "topTen.jsp";
	}
	
	@RequestMapping("/songs/new") //display a form to add song
	public String new_song(Model m, @ModelAttribute("song") Song song) {
		return "newsong.jsp";
	} 

	@PostMapping("/add") //add new song details into models
	public String addsong(Model m, @Valid @ModelAttribute("song") Song song, BindingResult res) {
		if (res.hasErrors()) { //validate
    		return "newsong.jsp"; //in case of errors send the client back to the page with a form
		} else {
			lookifyService.addsong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}") //display this song info
	public String show(Model m, @PathVariable ("id") Long id) {
		Song s = lookifyService.findById(id);
		m.addAttribute("song",s );
		return "show.jsp";
	} 
	
	@RequestMapping("/delete/{id}") //delete this song
	public String delete(@PathVariable ("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}

}
