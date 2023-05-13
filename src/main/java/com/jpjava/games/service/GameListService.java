package com.jpjava.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpjava.games.dto.GameListDTO;
import com.jpjava.games.entities.GameList;
import com.jpjava.games.projections.GameMinProjection;
import com.jpjava.games.repositories.GameListRepository;
import com.jpjava.games.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> resultfinal = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return resultfinal;
	
	}
	
	@Transactional //		2				3					1
	public void move (Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId); //busco a lista por id
		
		GameMinProjection obj = list.remove(sourceIndex); //remove
		list.add(destinationIndex, obj); // add no destino
		
		//define min e max para por em ordem
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; 
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; 
		
		for (int i = min; i <= max; i++) { // pego todos os index e atualizo no banco 
			
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}




