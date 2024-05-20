package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAllByEventEquals(String event);
    List<Log> findAllByUserId(Long id);
    @Query("select distinct l.userId from Log l")
    List<Integer> findDistinctByUserId();
}
