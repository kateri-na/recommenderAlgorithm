package com.recommender.recommenderAlgorithm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@Controller
public class StartController {
    @GetMapping
    public String start(){
        return "startPage";
    }
}
