package com.recday.jasonchan.jobcircle.Model;


/**
 * Created by Jason on 16/09/2018.
 *
 */


public class User {

    public int id;
    public int activate;
    public String email;
    public String username;
    public String gender;
    public String dob;
    public String phoneNo;
    public String hkidVerified;
    public String brNoVerified;
    public String token;
    public String apiKey;
    public String createdAt;

    public User() {
    }

    public User(int id, int activate, String email, String username, String gender, String dob, String phoneNo, String hkidVerified, String brNoVerified, String token, String apiKey, String createdAt) {
        this.id = id;
        this.activate = activate;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.hkidVerified = hkidVerified;
        this.brNoVerified = brNoVerified;
        this.token = token;
        this.apiKey = apiKey;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivate() {
        return activate;
    }

    public void setActivate(int activate) {
        this.activate = activate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getHkidVerified() {
        return hkidVerified;
    }

    public void setHkidVerified(String hkidVerified) {
        this.hkidVerified = hkidVerified;
    }

    public String getBrNoVerified() {
        return brNoVerified;
    }

    public void setBrNoVerified(String brNoVerified) {
        this.brNoVerified = brNoVerified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
