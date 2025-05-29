package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.services.LogService;
import com.recommender.recommenderAlgorithm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/log")
public class LogController {
    private final LogService logService;
    private final UserService userService;
    @Autowired
    public LogController(LogService logService, UserService userService) {
        this.userService = userService;
        this.logService = logService;
    }
    @GetMapping
    public List<Log> getLog(){
        return logService.getLog();
    }
    @PostMapping
    public void logEvent(@RequestParam("serialId") Integer serialId, @RequestParam("event") String event){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            User user = userService.getCurrentUser();
            Log log = new Log(user.getId(), serialId, event);
            logService.save(log);
        }
    }
}
