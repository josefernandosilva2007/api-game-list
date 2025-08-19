package com.fear.dslist.service;


import com.fear.dslist.dto.GameDTO;
import com.fear.dslist.dto.GameMinDTO;
import com.fear.dslist.entities.Game;
import com.fear.dslist.exceptions.GameNotFoundException;
import com.fear.dslist.projections.GameMinProjection;
import com.fear.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long id) {
        List<GameMinProjection> result = gameRepository.searchByList(id);
        return result.stream().map(GameMinDTO::new).toList();
    }


    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> byId = gameRepository.findById(id);
        if (byId.isPresent()) {
            return new GameDTO(byId.get());
        } else {
            throw new GameNotFoundException("Game Not Found");
        }
    }
}
