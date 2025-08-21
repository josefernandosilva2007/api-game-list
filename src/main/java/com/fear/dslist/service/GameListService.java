package com.fear.dslist.service;


import com.fear.dslist.dto.GameListDTO;
import com.fear.dslist.entities.GameList;
import com.fear.dslist.projections.GameMinProjection;
import com.fear.dslist.repositories.GameListRepository;
import com.fear.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository listRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> all = listRepository.findAll();
        return all.stream().map(GameListDTO::new).toList();
    }


    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++ ){
            listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }


    }
}
