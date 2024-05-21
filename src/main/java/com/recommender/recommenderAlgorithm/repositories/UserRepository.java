package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select distinct u.Id from User u")
    List<Integer> findDistinctUserId();
}
