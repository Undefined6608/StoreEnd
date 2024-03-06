package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

/**
 * @className: UserPhoneLoginRequest
 * @description:
 * @author: 15506
 * @date: 2024/2/21 9:00
 */
@Component
public class UserPhoneLoginRequest {
    private String phone;
    private String password;
    private String imgCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    @Override
    public String toString() {
        return "UserPhoneLoginRequest{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", imgCode='" + imgCode + '\'' +
                '}';
    }
}
