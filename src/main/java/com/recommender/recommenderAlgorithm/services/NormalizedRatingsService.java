package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.models.Similarities;
import com.recommender.recommenderAlgorithm.repositories.NormalizedRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalizedRatingsService {
    private final NormalizedRatingsRepository normalizedRatingsRepository;
    @Autowired
    public NormalizedRatingsService(NormalizedRatingsRepository normalizedRatingsRepository) {
        this.normalizedRatingsRepository = normalizedRatingsRepository;
    }
    public List<NormalizedRatings> getNormalizedRatings(){
        return normalizedRatingsRepository.findAll();
    }
    public void addNormalizedRating(Long userId, Long serialId, Double rating){
        NormalizedRatings normalizedRating = new NormalizedRatings(userId, serialId, rating);
        normalizedRatingsRepository.save(normalizedRating);
    }
    public List<NormalizedRatings> getAllSerialRatings(Long serialId){
        return normalizedRatingsRepository.findAllBySerialId(serialId);
    }
    public NormalizedRatings getCertainSerialRating(Long userId, Long serialId){
        return normalizedRatingsRepository.findByUserIdAndSerialId(userId,serialId).orElseThrow(()-> new IllegalStateException
                ("rating of "+userId+" user for serial "+serialId+" doesn't exist"));
    }
}
