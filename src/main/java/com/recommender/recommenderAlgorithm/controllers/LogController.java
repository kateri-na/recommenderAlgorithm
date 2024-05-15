package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/log")
public class LogController {
    private final LogService logService;
    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }
    @GetMapping
    public List<Log> getLog(){
        return logService.getLog();
    }
}
