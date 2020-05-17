package com.jongmin.springcore;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public class MovieRecommender {

    @Autowired
    private MovieCatalog movieCatalog;
}
