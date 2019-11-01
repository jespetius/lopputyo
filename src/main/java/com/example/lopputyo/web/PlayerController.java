package com.example.lopputyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lopputyo.domain.PlayerRepository;

@Controller

public class PlayerController {
	@Autowired
	private PlayerRepository repository;
	
@RequestMapping("/playerlist")
	public String playerList(Model model) {
		model.addAttribute("players", repository.findAll());
		return "playerList";
	}
	
}
