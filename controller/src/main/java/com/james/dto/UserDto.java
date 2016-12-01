package com.james.dto;

/**
 * Created by eronzen on 11/28/2016.
 */
public class UserDto {

    private String userName;

    private String password;

    private String vVerificationCode;

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

    public String getvVerificationCode() {
        return vVerificationCode;
    }

    public void setvVerificationCode(String vVerificationCode) {
        this.vVerificationCode = vVerificationCode;
    }
}
