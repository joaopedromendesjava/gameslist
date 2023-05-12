package com.jpjava.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpjava.games.dto.GameListDTO;
import com.jpjava.games.entities.GameList;
import com.jpjava.games.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> resultfinal = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return resultfinal;
	
	}
}


