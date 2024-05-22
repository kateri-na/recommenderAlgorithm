package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.Similarities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SimilarityRepository extends JpaRepository<Similarities, Long> {
    @Query(value = "select s from Similarities s where (s.serialColumnId = :serialId or s.serialRowId = :serialId) and s.similarity > :constraint")
    List<Similarities> findAllGreaterThanConstraint(@Param("serialId") Long serialId,
                                        @Param("constraint") double similarityConstraint);
}
