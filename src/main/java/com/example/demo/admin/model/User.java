package com.example.demo.admin.model;

/**
 * Created by tuyuelai on 2017/6/9.
 */
public class User {
    private int userId;
    private String userName;
    private int state;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
