package com.jpjava.games.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpjava.games.dto.GameMinDTO;
import com.jpjava.games.entities.Game;
import com.jpjava.games.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll(){

		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> gameDto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return gameDto;
	}
}
