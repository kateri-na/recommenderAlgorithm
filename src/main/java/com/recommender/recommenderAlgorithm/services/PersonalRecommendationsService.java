package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalRecommendationsService {
    private final RatingsService ratingsService;
    private final UserService userService;
    private final SimilarityService similarityService;
    @Autowired
    public PersonalRecommendationsService(RatingsService ratingsService, UserService userService,
                                          SimilarityService similarityService) {
        this.ratingsService = ratingsService;
        this.userService = userService;
        this.similarityService = similarityService;
    }

    public void calculateSimilarity(){
        for (Integer i=1; i<10; ++i){
            for(Integer j = i+1; j<=10; ++j) {
                List<Ratings> column1 = ratingsService.getAllSerialRatings(i.longValue());
                List<Ratings> column2 = ratingsService.getAllSerialRatings(j.longValue());
                similarityService.addSimilarity(i, j, similarityFormula(column1, column2));
            }
        }
    }

    public void normalizeRatings(){
        List<Integer> usersIds = userService.getUsersIds();
        double averageRating = 0.0;
        for(int i =0; i<usersIds.size(); ++i){
            List<Ratings> userRatings = ratingsService.getAllUserRatings(usersIds.get(i).longValue());
            averageRating = calculateAverage(userRatings);
            for(Ratings rating :userRatings){
                if(rating.getRatingValue() != 0) {
                    ratingsService.updateRating(rating.getUserId(), rating.getSerialId(),
                            rating.getRatingValue() - averageRating);
                }
            }
        }
    }
    private double calculateAverage(List<Ratings> ratings){
        int count = 0;
        double result = 0.0;
        for(int i =0; i<ratings.size(); ++i){
            if(ratings.get(i).getRatingValue() != 0.0){
                ++count;
                result +=ratings.get(i).getRatingValue();
            }
        }
        return result/count;
    }
    private double similarityFormula(List<Ratings> column1, List<Ratings> column2){
        double numerator = 0.0;
        double denominator1 = 0.0;
        double denominator2 = 0.0;
        for(int i=1; i< column1.size(); ++i){
            numerator += (column1.get(i).getRatingValue() * column2.get(i).getRatingValue());
            denominator1 += Math.pow(column1.get(i).getRatingValue(),2);
            denominator2 += Math.pow(column2.get(i).getRatingValue(),2);
        }
        return numerator/(Math.sqrt(denominator1)*Math.sqrt(denominator2));
    }
}
