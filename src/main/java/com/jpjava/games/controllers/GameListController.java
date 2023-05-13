package com.jpjava.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpjava.games.dto.GameListDTO;
import com.jpjava.games.dto.GameMinDTO;
import com.jpjava.games.dto.ReplacementDTO;
import com.jpjava.games.service.GameListService;
import com.jpjava.games.service.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameservice;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> result = gameListService.findAll();
		
		return result;
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable(value = "listId") Long listId){
		
		List<GameMinDTO> result = gameservice.findByList(listId);
		
		return result;
	}
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
	
}







