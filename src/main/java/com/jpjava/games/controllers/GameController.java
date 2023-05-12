package com.jpjava.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpjava.games.dto.GameDTO;
import com.jpjava.games.dto.GameMinDTO;
import com.jpjava.games.service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		
		List<GameMinDTO> result = gameService.findAll();
		
		return result;
	}
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable(value = "id") Long id){
		 
		GameDTO result = gameService.findById(id);
	
		return result;
	}
}
