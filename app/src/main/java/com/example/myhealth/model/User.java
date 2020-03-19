package com.example.myhealth.model;

import android.content.Context;
import android.content.SharedPreferences;


public class User {

    private int id;
    private String  name,age,gender,email, username,password,sq, answer;
 public  User(){}

    public User(int id, String name, String age, String gender, String email, String username, String password, String sq, String answer) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sq = sq;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSq() {
        return sq;
    }

    public String getAnswer() {
        return answer;
    }
}
