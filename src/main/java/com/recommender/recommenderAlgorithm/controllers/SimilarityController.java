package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Similarities;
import com.recommender.recommenderAlgorithm.services.SimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/similarities")
public class SimilarityController {
    private SimilarityService similarityService;
    @Autowired
    public SimilarityController(SimilarityService similarityService) {
        this.similarityService = similarityService;
    }
    @GetMapping
    public List<Similarities> getSimilarities(){
        return similarityService.getSimilarities();
    }
}
