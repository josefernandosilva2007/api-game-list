package com.fear.dslist.controller;


import com.fear.dslist.dto.GameMinDTO;
import com.fear.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.findAll());
    }

}
