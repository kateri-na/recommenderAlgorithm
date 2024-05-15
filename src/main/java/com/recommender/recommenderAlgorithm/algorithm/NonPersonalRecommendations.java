package com.recommender.recommenderAlgorithm.algorithm;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.repositories.LogRepository;
import com.recommender.recommenderAlgorithm.services.LogService;
import com.recommender.recommenderAlgorithm.services.SerialService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "api/nonPersonal")
public class NonPersonalRecommendations {
    private final LogService logService;
    private final SerialService serialService;
    private HashMap<Integer, Integer> mapViews;
    @Autowired
    public NonPersonalRecommendations(LogService logService, SerialService serialService) {
        this.logService = logService;
        this.serialService = serialService;
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
    public List<String> formatMap() {
        List<String> result = new LinkedList<String>();
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(
                Comparator.comparing(mapViews::get, (s1, s2) -> {
                    return s2.compareTo(s1);}));
        sortedMap.putAll(mapViews);
        Set<Integer> keys = sortedMap.keySet();
        for (Integer key:keys) {
            result.add(serialService.getById(key.longValue()).getSerialName());
        }
        return result;
    }
    @GetMapping
    public List<String> getMostWatched(){
        calculateWatches();
        return formatMap();
    }
}
