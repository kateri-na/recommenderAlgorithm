package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/ratings")
public class RatingsController {
    private RatingsService ratingsService;
    @Autowired
    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }
    @GetMapping
    public List<Ratings> getRatings(){
        return ratingsService.getRatings();
    }
}
