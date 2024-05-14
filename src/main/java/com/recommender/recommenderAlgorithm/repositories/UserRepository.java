package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
