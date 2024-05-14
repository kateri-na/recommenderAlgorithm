package com.recommender.recommenderAlgorithm.models;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userSurname;
    private String userName;
    private String userMiddleName;
    private String email;

    public User() {}
    public User(Long id, String userSurname, String userName, String userMiddleName, String email) {
        this.id = id;
        this.userSurname = userSurname;
        this.userName = userName;
        this.userMiddleName = userMiddleName;
        this.email = email;
    }
    public User(String userSurname, String userName, String userMiddleName, String email) {
        this.userSurname = userSurname;
        this.userName = userName;
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
                ", userSurname='" + userSurname + '\'' +
                ", userName='" + userName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
