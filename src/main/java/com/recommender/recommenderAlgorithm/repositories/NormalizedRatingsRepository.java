package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.NormalizedRatings;
import com.recommender.recommenderAlgorithm.models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NormalizedRatingsRepository extends JpaRepository<NormalizedRatings, Long> {
    @Query(value = "select n from NormalizedRatings n where n.serialId = :serialId")
    List<NormalizedRatings> findAllBySerialId(@Param("serialId") Long serialId);
    @Query(value = "select n from NormalizedRatings n where n.userId = :userId and n.serialId = :serialId")
    Optional<NormalizedRatings> findByUserIdAndSerialId(@Param("userId") Long userId, @Param("serialId") Long serialId);
}
