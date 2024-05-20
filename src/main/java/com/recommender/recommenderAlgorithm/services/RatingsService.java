package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingsService {
    private RatingsRepository ratingsRepository;
    @Autowired
    public RatingsService(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }
    public List<Ratings> getRatings(){
        return ratingsRepository.findAll();
    }
    @Transactional
    public void updateRating(Long userId, Long serialID, Double value){
        Ratings ratings = ratingsRepository.findByUserIdAndSerialId(userId, serialID)
                .orElseThrow(()-> new IllegalStateException
                        ("rating of "+userId+" user for serial "+serialID+" doesn't exist"));
        ratings.setRatingValue(value);
        ratingsRepository.save(ratings);
    }
}
