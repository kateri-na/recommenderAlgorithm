package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Serial;
import com.recommender.recommenderAlgorithm.services.SerialService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/serials")
public class SerialController {
    private final SerialService serialService;
    @Autowired
    public SerialController(SerialService serialService) {
        this.serialService = serialService;
    }
    @GetMapping
    public List<Serial> getSerials(){
        return serialService.getSerials();
    }
}
