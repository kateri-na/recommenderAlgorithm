package com.recommender.recommenderAlgorithm.repositories;

import com.recommender.recommenderAlgorithm.models.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerialRepository extends JpaRepository<Serial, Long> {
}
