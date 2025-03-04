package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<Integer> getUsersIds() {
        return userRepository.findDistinctUserId();
    }
}
