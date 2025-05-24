package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.security.UserDetails;
import com.recommender.recommenderAlgorithm.services.PersonalRecommendationsService;
import com.recommender.recommenderAlgorithm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;
    private final PersonalRecommendationsService personalRecommendationsService;
    @Autowired
    public UserController(UserService userService, PersonalRecommendationsService personalRecommendationsService) {
        this.userService = userService;
        this.personalRecommendationsService = personalRecommendationsService;
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/personalAccount")
    public String getUser(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("currentUser", userDetails.getUser());
        model.addAttribute("recommendations",
                personalRecommendationsService.recommendationsForCertainUser(userDetails.getUser().getId()));
        return "personalAccount";
    }
}