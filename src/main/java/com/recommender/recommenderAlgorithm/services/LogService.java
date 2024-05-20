package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class LogService {
    private LogRepository logRepository;
    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
    public List<Log> getLog(){
        return logRepository.findAll();
    }
    public List<Log> getWatchedLogs(){
        return logRepository.findAllByEventEquals("просмотр серии");
    }
    public List<Log> getUsersLogsById(Long id){
        return logRepository.findAllByUserId(id.longValue());
    }
    public List<Integer> getDistinctUsersIds(){
        return logRepository.findDistinctByUserId();
    }

}
