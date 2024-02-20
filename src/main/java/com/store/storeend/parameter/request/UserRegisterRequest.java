package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

@Component
public class UserRegisterRequest {
    private String userName;
    private String password;
    private String verPassword;
    private String email;
    private String phone;
    private String emailCode;
    private String imgCode;
    private String gender;
    private String avatar;

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

    public String getVerPassword() {
        return verPassword;
    }

    public void setVerPassword(String verPassword) {
        this.verPassword = verPassword;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", verPassword='" + verPassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", emailCode='" + emailCode + '\'' +
                ", imgCode='" + imgCode + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
