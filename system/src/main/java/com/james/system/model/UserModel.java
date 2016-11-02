package com.james.system.model;

/**
 * Created by james on 2016/11/2.
 */
public class UserModel {

    private  String userName;

    private String password;

    public UserModel() {
    }

    public UserModel(String userName) {
        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
