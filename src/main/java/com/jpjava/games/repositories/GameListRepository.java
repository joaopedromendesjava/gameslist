package com.jpjava.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpjava.games.entities.GameList;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

	
}
