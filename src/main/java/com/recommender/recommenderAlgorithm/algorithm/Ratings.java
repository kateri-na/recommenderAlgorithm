package com.recommender.recommenderAlgorithm.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ratings {
    private Double[][] matrix = new Double[4][10];
    Ratings(){}
    Ratings(List<Double> values){
        for(int i =0; i< matrix.length; ++i){
            for(int j =0; i<matrix[i].length; ++j){
                for(Double elem:values) {
                    matrix[i][j] = elem;
                }
            }
        }
    }

}
