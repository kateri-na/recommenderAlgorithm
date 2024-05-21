package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.*;

@Table
@Entity
public class Similarities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer serialRowId;
    private Integer serialColumnId;
    private Double similarity;
    public Similarities(){}

    public Similarities(Integer serialRowId, Integer serialColumnId, Double similarity) {
        this.serialRowId = serialRowId;
        this.serialColumnId = serialColumnId;
        this.similarity = similarity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialRowId() {
        return serialRowId;
    }

    public void setSerialRowId(Integer serialRowId) {
        this.serialRowId = serialRowId;
    }

    public Integer getSerialColumnId() {
        return serialColumnId;
    }

    public void setSerialColumnId(Integer serialColumnId) {
        this.serialColumnId = serialColumnId;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }
}
