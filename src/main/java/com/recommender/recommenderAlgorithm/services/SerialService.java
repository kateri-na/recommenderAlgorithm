package com.recommender.recommenderAlgorithm.services;

import com.recommender.recommenderAlgorithm.models.Serial;
import com.recommender.recommenderAlgorithm.repositories.SerialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerialService {
    private SerialRepository serialRepository;
    @Autowired
    public SerialService(SerialRepository serialRepository) {
        this.serialRepository = serialRepository;
    }
    public List<Serial> getSerials(){
        return serialRepository.findAll();
    }
}
