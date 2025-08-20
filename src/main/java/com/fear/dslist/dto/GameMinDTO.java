package com.fear.dslist.dto;

import com.fear.dslist.entities.Game;
import com.fear.dslist.projections.GameMinProjection;

public class GameMinDTO {
    String title;
    Long id;
    Integer year;
    String imgUrl;
    String shortDescription;


    public GameMinDTO(){
    }

    public GameMinDTO(Game entity) {
        title = entity.getTitle();
        id = entity.getId();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }


    public GameMinDTO(GameMinProjection entity) {
        title = entity.getTitle();
        id = entity.getId();
        year = entity.getGameYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
