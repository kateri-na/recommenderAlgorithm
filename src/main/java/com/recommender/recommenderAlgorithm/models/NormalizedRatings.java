package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.*;

@Table
@Entity
public class NormalizedRatings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long serialId;

    private double ratingValue;

    public NormalizedRatings() {}

    public NormalizedRatings(Long userId, Long serialId, double ratingValue) {
        this.userId = userId;
        this.serialId = serialId;
        this.ratingValue = ratingValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(double ratingValue) {
        this.ratingValue = ratingValue;
    }
}
