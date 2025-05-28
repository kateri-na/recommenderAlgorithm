package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.security.UserDetails;
import com.recommender.recommenderAlgorithm.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/ratings")
public class RatingsController {
    private RatingsService ratingsService;
    @Autowired
    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }
    @GetMapping
    public List<Ratings> getRatings(){
        return ratingsService.getRatings();
    }
    @PostMapping()
    public RedirectView rateSerial(@RequestParam Long serialId, @RequestParam Double mark){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((UserDetails)authentication.getPrincipal()).getUser().getId();
        ratingsService.rateSerial(userId, serialId, mark);
        return new RedirectView("/api/serials/"+ serialId);
    }
}
