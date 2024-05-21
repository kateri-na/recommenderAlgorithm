package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalRecommendationsService {
    private final RatingsService ratingsService;
    private final UserService userService;
    @Autowired
    public PersonalRecommendationsService(RatingsService ratingsService, UserService userService) {
        this.ratingsService = ratingsService;
        this.userService = userService;
    }

    public void normalizeRatings(){
        List<Ratings> zeroRatings = ratingsService.getZeroRatings();
        List<Integer> usersIds = userService.getUsersIds();
        double averageRating = 0.0;
        for(int i =0; i<usersIds.size(); ++i){
            List<Ratings> userRatings = ratingsService.getAllUserRatings(usersIds.get(i).longValue());
            averageRating = calculateAverage(userRatings);
            for(Ratings rating :userRatings){
                ratingsService.updateRating(rating.getUserId(),rating.getSerialId(),
                        rating.getRatingValue()/averageRating);
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
}
