package com.recommender.recommenderAlgorithm.repo;

import com.recommender.recommenderAlgorithm.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
