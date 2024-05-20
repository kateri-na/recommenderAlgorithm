package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.services.LogService;
import com.recommender.recommenderAlgorithm.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ImplicitRatingsCalculation {
    public final static int playEpisode = 100;
    public final static int viewDescription = 50;
    public final static int viewEpisodesSeasonsNumber = 25;
    private final LogService logService;
    private final RatingsService ratingsService;
    @Autowired
    public ImplicitRatingsCalculation(LogService logService, RatingsService ratingsService) {
        this.logService = logService;
        this.ratingsService = ratingsService;
    }

    public void Calculation(){
        List<Integer> usersId = logService.getDistinctUsersIds();
        for(Integer i = 0; i < usersId.size(); ++i){
            Map<Integer, Double> mapSerialRating= new HashMap<Integer,Double>();
            List<Log> userLogs = logService.getUsersLogsById(usersId.get(i).longValue());
            for(Log log:userLogs){
                if(mapSerialRating.containsKey(log.getSerialId())){
                    mapSerialRating.replace(log.getSerialId(), mapSerialRating.get(log.getSerialId()),
                            mapSerialRating.get(log.getSerialId()) + calculateRating(log.getEvent()));
                }
                else{
                    mapSerialRating.put(log.getSerialId(), calculateRating(log.getEvent()));
                }
            }
            normalizeRating(mapSerialRating);
            for(Map.Entry<Integer, Double> elem: mapSerialRating.entrySet()){
                ratingsService.updateRating(usersId.get(i).longValue(),elem.getKey().longValue(), elem.getValue());
            }
        }
    }

    private Double calculateRating(String event){
        Double result = 0.0;
        switch (event){
            case "просмотр серии":
                result = (double)playEpisode;
                break;
            case "просмотр описания":
                result = (double)viewDescription;
                break;
            case "просмотр количества сезонов и серий":
                result = (double)viewEpisodesSeasonsNumber;
                break;
            default:
                new IllegalArgumentException("Неизвестное взаимодействие пользователя");
        }
        return result;
    }
    private void normalizeRating(Map<Integer, Double> mapSerialRating){
        Double max = Collections.max(mapSerialRating.values());
        for(Map.Entry<Integer, Double> elem :mapSerialRating.entrySet()){
            elem.setValue(10*(elem.getValue()/max));
        }
    }
}
