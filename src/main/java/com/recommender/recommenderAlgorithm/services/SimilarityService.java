package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Similarities;
import com.recommender.recommenderAlgorithm.repositories.SimilarityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimilarityService {
    private final SimilarityRepository similarityRepository;
    @Autowired
    public SimilarityService(SimilarityRepository similarityRepository) {
        this.similarityRepository = similarityRepository;
    }
    public List<Similarities> getSimilarities(){
        return similarityRepository.findAll();
    }
    public void addSimilarity(Integer serialRowId, Integer serialColumnId, Double similarity){
        Similarities similarities = new Similarities(serialRowId, serialColumnId, similarity);
        similarityRepository.save(similarities);
    }
    public Optional<Similarities> findExistedSimilarity(Long serialRowId, Long serialColumnId){
        return similarityRepository.findBySerialRowIdAndSerialColumnId(serialRowId, serialColumnId);
    }
    public void updateSimilarity(Long similarityId, double value){
        Optional<Similarities> findingSimilarity = similarityRepository.findById(similarityId);
        if (findingSimilarity.isPresent()){
            findingSimilarity.get().setSimilarity(value);
            similarityRepository.save(findingSimilarity.get());
        }else  throw new RuntimeException("Modified similarity not found");
    }
     public List<Similarities> getNeighborhood(Long serialId, double similarityConstraint){
        return similarityRepository.findAllGreaterThanConstraint(serialId,similarityConstraint);
     }
}
