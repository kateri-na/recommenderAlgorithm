package com.recommender.recommenderAlgorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {
    public void calculate(){
        List<Double> values = Arrays.asList(10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 8.0, 0.0, 0.0,
                                            0.0, 0.0, 0.0, 8.0, 0.0, 0.0, 10.0, 0.0, 0.0, 7.0,
                                            0.0, 0.0, 7.5, 0.0, 8.5, 8.0, 0.0, 0.0, 9.5, 0.0,
                                            0.0, 0.0, 0.0, 0.0, 0.0, 8.8, 0.0, 0.0, 7.3, 0.0);
        Ratings explicitRatings = new Ratings(values);
        ImplicitRatingsCalculation ratingsCalculation = new ImplicitRatingsCalculation(explicitRatings);
    }
}
