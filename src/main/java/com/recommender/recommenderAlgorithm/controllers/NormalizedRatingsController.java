package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import com.recommender.recommenderAlgorithm.services.NormalizedRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/normalizedRatings")
public class NormalizedRatingsController {
    private final NormalizedRatingsService normalizedRatingsService;
    @Autowired
    public NormalizedRatingsController(NormalizedRatingsService normalizedRatingsService) {
        this.normalizedRatingsService = normalizedRatingsService;
    }
    @GetMapping
    public List<NormalizedRatings> getNormalizedRatings(){
        return normalizedRatingsService.getNormalizedRatings();
    }
}
