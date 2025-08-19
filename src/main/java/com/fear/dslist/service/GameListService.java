package com.fear.dslist.service;


import com.fear.dslist.dto.GameListDTO;
import com.fear.dslist.entities.GameList;
import com.fear.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository listRepository;

    public List<GameListDTO> findAll(){
        List<GameList> all = listRepository.findAll();
        return all.stream().map(GameListDTO::new).toList();
    }
}
