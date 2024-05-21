package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long> {
    @Query(value = "select c from Ratings c where c.userId = :userId and c.serialId = :serialId")
    Optional<Ratings> findByUserIdAndSerialId(@Param("userId") Long userId,@Param("serialId") Long serialId);
    @Query(value = "select r from Ratings r where r.ratingValue = 0")
    List<Ratings> findAllZeroRatings();
    @Query(value = "select r from Ratings r where r.userId = :userId")
    List<Ratings> findAllByUserId(@Param("userId") Long userId);
}
