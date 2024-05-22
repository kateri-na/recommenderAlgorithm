package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.services.PersonalRecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/ratings")
public class PersonalRecommendationsController {
    private final PersonalRecommendationsService personalRecommendationsService;
    @Autowired
    public PersonalRecommendationsController(PersonalRecommendationsService personalRecommendationsService) {
        this.personalRecommendationsService = personalRecommendationsService;
    }
    @GetMapping("/normalize")
    public ResponseEntity<Void> getRatings(){
        personalRecommendationsService.normalizeRatings();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/similarity")
    public ResponseEntity<Void> getRating(){
        personalRecommendationsService.calculateSimilarity();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/predictions")
    public List<Ratings> getPredictedRatings(){
        return personalRecommendationsService.predictedRatings();
    }
}
