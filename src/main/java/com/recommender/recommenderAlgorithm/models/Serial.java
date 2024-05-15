package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Serial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialName;
    private Integer seasonsNumber;
    private Integer episodeDuration;
    private List<String> genres;

    public Serial(){}

    public Serial(String serialName, Integer seasonsNumber, Integer episodeDuration, List<String> genres) {
        this.serialName = serialName;
        this.seasonsNumber = seasonsNumber;
        this.episodeDuration = episodeDuration;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public Integer getSeasonsNumber() {
        return seasonsNumber;
    }

    public void setSeasonsNumber(Integer seasonsNumber) {
        this.seasonsNumber = seasonsNumber;
    }

    public Integer getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(Integer episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "id=" + id +
                ", serialName='" + serialName + '\'' +
                ", seasonsNumber=" + seasonsNumber +
                ", episodeDuration=" + episodeDuration +
                ", genres=" + genres.toString() +
                '}';
    }
}
