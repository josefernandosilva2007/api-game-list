package com.fear.dslist.controller;


import com.fear.dslist.dto.GameListDTO;
import com.fear.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService listService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(listService.findAll());
    }
}
