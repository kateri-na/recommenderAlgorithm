package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.repo.UserRepository;
import com.recommender.recommenderAlgorithm.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private final StudentsService studentsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @GetMapping
    public List<User> getUsers(){
        return studentsService.getUsers();
    }
//    public String showUsers(){
//        Iterable<User> users = userRepository.findAll();
//        return users.toString();
//    }

}
