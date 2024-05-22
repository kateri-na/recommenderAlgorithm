package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalizedRatingsRepository extends JpaRepository<NormalizedRatings, Long> {
}
