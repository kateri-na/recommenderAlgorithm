package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.services.ImplicitRatingsCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/ratings")
public class ImplicitRatingsCalculationController {
    private final ImplicitRatingsCalculation calculation;
    @Autowired
    public ImplicitRatingsCalculationController(ImplicitRatingsCalculation calculation) {
        this.calculation = calculation;
    }
    @GetMapping("/refresh")
    public ResponseEntity<Void> getRatings(){
        calculation.Calculation();
        return ResponseEntity.noContent().build();
    }
}
