package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "id",length = 10, nullable = false)
    private Integer id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "gender", nullable = false)
    private Boolean gender;
    @Column(name = "limit",length = 10, nullable = false)
    private Integer limit;
    @Column(name = "avatar", nullable = false)
    private String avatar;
    @Column(name = "integral",length = 10, nullable = false)
    private Integer integral;
    @Column(name = "balance",length = 10, nullable = false)
    private Integer balance;
    @Column(name = "enable", nullable = false)
    private Boolean enable;
    @Column(name = "like",length = 10, nullable = false)
    private Integer like;
    @Column(name = "dont_like",length = 10, nullable = false)
    private Integer dontLike;
    @Column(name = "uid",length = 36, nullable = false)
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", limit=" + limit +
                ", avatar='" + avatar + '\'' +
                ", integral=" + integral +
                ", balance=" + balance +
                ", enable=" + enable +
                ", like=" + like +
                ", dontLike=" + dontLike +
                ", uid='" + uid + '\'' +
                '}';
    }
}
