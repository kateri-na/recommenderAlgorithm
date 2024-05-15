package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
