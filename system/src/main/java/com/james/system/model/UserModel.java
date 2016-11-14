package com.james.system.model;

/**
 * Created by james on 2016/11/2.
 */
public class UserModel {

    private  String userName;

    private String password;

    private String mail;

    private String address;

    static {
        System.out.print("========");
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
