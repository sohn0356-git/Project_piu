package com.mp.piu_mobile_test;

public class User {
    private String profile;
    private String id;
    private int pw;
    private String userName;

    public User(){

    }
    public String getProfile() {
        return profile;
    }

    public String getId() {
        return id;
    }

    public int getPw() {
        return pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
