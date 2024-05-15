package com.recommender.recommenderAlgorithm.algorithm;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.repositories.LogRepository;
import com.recommender.recommenderAlgorithm.services.LogService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/nonPersonal")
public class NonPersonalRecommendations {
    private final LogService logService;
    private HashMap<Integer, Integer> mapViews;
    @Autowired
    public NonPersonalRecommendations(LogService logService) {
        this.logService = logService;
        mapViews = new HashMap<>();
    }
    public void calculateWatches(){
        List<Log> watchedEvents = logService.getWatchedLogs();
        for(Log event: watchedEvents){
            if(mapViews.containsKey(event.getSerialId())){
                mapViews.replace(event.getSerialId(),mapViews.get(event.getSerialId()),
                        mapViews.get(event.getSerialId())+ 1);
            }
            else{
                mapViews.put(event.getSerialId(), 1);
            }
        }
    }
//    public List<String> formatMap(){
//
//    }
    @GetMapping
    public String getMostWatched(){
        calculateWatches();
        return mapViews.toString();
    }
}
