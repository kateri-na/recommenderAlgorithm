package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
