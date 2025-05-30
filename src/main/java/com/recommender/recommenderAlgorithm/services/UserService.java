package com.recommender.recommenderAlgorithm.services;
import com.recommender.recommenderAlgorithm.security.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((UserDetails)authentication.getPrincipal()).getUser();
        return userRepository.findById(currentUser.getId()).orElse(null);
    }
    public void save(User user) {
        userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<Integer> getUsersIds() {
        return userRepository.findDistinctUserId();
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
