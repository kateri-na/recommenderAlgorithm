package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 1)
    private Long id;
    private Long userId;
    private Integer serialId;
    private String event;
    public Log(){}
    public Log(Long userId, Integer serialId, String event) {
        this.userId = userId;
        this.serialId = serialId;
        this.event = event;
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

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userId=" + userId +
                ", serialId=" + serialId +
                ", event='" + event + '\'' +
                '}';
    }
}
