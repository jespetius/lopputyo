package com.example.lopputyo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.lopputyo.domain.Player;
import com.example.lopputyo.domain.PlayerRepository;
import com.example.lopputyo.domain.User;
import com.example.lopputyo.domain.UserRepository;

@Controller
public class MainController {
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private PlayerRepository prepository;
//etusivu
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	//rekisteröityminen
	//
	@GetMapping("/signin")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		
		return "signin";
	}
	
	@PostMapping("/sigin")
	public String saveUser(User user) {
		urepository.save(user);
		return "redirect:/login";
	}
	
	//kirjautuminen
	@GetMapping({ "/login"})
	public String login() {
		return "login";
	}
	@GetMapping({ "/hello"})
	public String hello() {
		return "hello";
	}	
	//virhe tapahtuu
	@GetMapping({ "/error"})
	public String error() {
		return "error";
	}	
	//lista pelaajista
	@GetMapping({"/playerlist"})
	public String playerList(Model model) {
		model.addAttribute("players", prepository.findAll());	
		return "playerlist";
	}
	
	//uuden pelaajan lisääminen
	@GetMapping("/addplayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		
		return "addplayer";
	}
	
	//uuden pelaajan lisääminen
	@PostMapping("/addplayer")
	public String savePlayer1(Player player) {
		prepository.save(player);
		return "redirect:/playerlist";
	}	
	// pelaajan poisto
		@GetMapping("/delete/{id}")
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deletePlayer(@PathVariable("id") Long playerId) {
			prepository.deleteById(playerId);
			return "redirect:../playerlist";
		}
		
		// pelaajan muokkaaminen
		@GetMapping("/edit/{id}")
		public String editPlayer(@PathVariable("id") Long playerId, Model model) {
			model.addAttribute("player", prepository.findById(playerId));
			return "editplayer";
		}
		@PostMapping("/editplayer")
		public String savePlayer(Player player) {
			prepository.save(player);
			return "redirect:/playerlist";
		}
		
		// API palauttaa kaikki pelaajat
		@GetMapping("/api")
		public @ResponseBody List<Player> listAllPlayers() {
			return (List<Player>) prepository.findAll();
		}
		
		// API palauttaa pelaajan idllä
		@GetMapping("/api/{id}")
		public @ResponseBody Optional<Player> listPlayerById(@PathVariable("id") Long playerId) {
			return prepository.findById(playerId);
		}

}
	