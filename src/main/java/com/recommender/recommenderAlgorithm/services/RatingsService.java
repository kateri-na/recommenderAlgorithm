package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.repositories.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<Ratings> getZeroRatings(){return ratingsRepository.findAllZeroRatings();}
    public List<Ratings> getAllUserRatings(Long userId){ return ratingsRepository.findAllByUserId(userId);}
    public List<Ratings> getAllSerialRatings(Long serialId){return ratingsRepository.findAllBySerialId(serialId);}
    public Ratings getCertainSerialRating(Long userId, Long serialId){
        return ratingsRepository.findByUserIdAndSerialId(userId,serialId).orElseThrow(()-> new IllegalStateException
            ("rating of "+userId+" user for serial "+serialId+" doesn't exist"));
    }
    @Transactional
    public void updateRating(Long userId, Long serialID, Double value){
        Ratings ratings = ratingsRepository.findByUserIdAndSerialId(userId, serialID)
                .orElseThrow(()-> new IllegalStateException
                        ("rating of "+userId+" user for serial "+serialID+" doesn't exist"));
        ratings.setRatingValue(value);
        ratingsRepository.save(ratings);
    }
    public void rateSerial(Long userId, Long serialId, Double value){
        Optional<Ratings> ratings = ratingsRepository.findByUserIdAndSerialId(userId, serialId);
        if(ratings.isPresent())
            updateRating(userId, serialId, value);
        else
            ratingsRepository.save(new Ratings(userId, serialId, value));
    }
}
