package com.jpjava.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpjava.games.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	
}
