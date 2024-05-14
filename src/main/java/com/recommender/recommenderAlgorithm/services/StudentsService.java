package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentsService {
    public List<User> getUsers(){
        return List.of(new User(1l, "Иванов", "Иван",
                "Иванович", "ivanIvanov@mail.ru"));
    }
}
