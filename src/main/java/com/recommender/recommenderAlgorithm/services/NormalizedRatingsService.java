package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.models.Similarities;
import com.recommender.recommenderAlgorithm.repositories.NormalizedRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void updateNormalizedRating(Long normalizedRatingId, double value) {
        Optional<NormalizedRatings> normalizedRatings = normalizedRatingsRepository.findById(normalizedRatingId);
        if(normalizedRatings.isPresent()) {
            normalizedRatings.get().setRatingValue(value);
            normalizedRatingsRepository.save(normalizedRatings.get());
        }else throw new RuntimeException("updated rating not found");
    }
    public Optional<NormalizedRatings> findExistingRating(Long userId, Long serialId){
        return normalizedRatingsRepository.findByUserIdAndSerialId(userId, serialId);
    }
    public List<NormalizedRatings> getAllSerialRatings(Long serialId){
        return normalizedRatingsRepository.findAllBySerialId(serialId);
    }
    public NormalizedRatings getCertainSerialRating(Long userId, Long serialId){
        return normalizedRatingsRepository.findByUserIdAndSerialId(userId,serialId).orElseThrow(()-> new IllegalStateException
                ("rating of "+userId+" user for serial "+serialId+" doesn't exist"));
    }
}
