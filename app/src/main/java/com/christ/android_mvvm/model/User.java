package com.christ.android_mvvm.model;

public class User {
    private String username;
    private String userid;
    private String password;
    private String phone;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String show() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("username：");
        stringBuilder.append(username);
        stringBuilder.append(" ");
        stringBuilder.append("userId：");
        stringBuilder.append(userid);
        stringBuilder.append(" ");
        stringBuilder.append("password：");
        stringBuilder.append(password);
        stringBuilder.append(" ");
        stringBuilder.append("phone：");
        stringBuilder.append(phone);
        stringBuilder.append(" ");
        stringBuilder.append("email：");
        stringBuilder.append(email);
        return stringBuilder.toString();
    }
}
