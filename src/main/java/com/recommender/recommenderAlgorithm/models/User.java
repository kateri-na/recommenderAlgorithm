package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String userSurname;
    private String userMiddleName;
    private String email;

    public User() {}
    public User(Long id, String userName, String userSurname, String userMiddleName, String email) {
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userMiddleName = userMiddleName;
        this.email = email;
    }
    public User(String userName, String userSurname, String userMiddleName, String email) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userMiddleName = userMiddleName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
