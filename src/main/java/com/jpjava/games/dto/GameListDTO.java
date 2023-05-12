package com.jpjava.games.dto;

import com.jpjava.games.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList gameList) {
		super();
		this.id = gameList.getId();
		this.name = gameList.getName();
	}
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	

}
