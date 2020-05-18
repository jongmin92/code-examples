package com.jongmin.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;

@Getter
public class MovieRecommender {

    @Autowired
    private MovieCatalog movieCatalog;

    @Autowired
    @Qualifier("second")
    private MovieCatalog movieCatalog2;
}
