package com.store.storeend.parameter.response;

import org.springframework.stereotype.Component;

@Component
public class UserInfoResponse {
    private Integer id;
    private String userName;
    private String email;
    private String phone;
    private Boolean gender;
    private Integer limit;
    private String avatar;
    private Integer integral;
    private Integer balance;
    private Integer like;
    private Integer dontLike;
    private String uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDontLike() {
        return dontLike;
    }

    public void setDontLike(Integer dontLike) {
        this.dontLike = dontLike;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", limit=" + limit +
                ", avatar='" + avatar + '\'' +
                ", integral=" + integral +
                ", balance=" + balance +
                ", like=" + like +
                ", dontLike=" + dontLike +
                ", uid='" + uid + '\'' +
                '}';
    }
}
