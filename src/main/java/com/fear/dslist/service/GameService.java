package com.fear.dslist.service;


import com.fear.dslist.dto.GameMinDTO;
import com.fear.dslist.entities.Game;
import com.fear.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream().map(GameMinDTO::new).toList();
    }
}
