package com.store.storeend.parameter.response;

import java.util.Stack;

/**
 * @className: UserLoginResponse
 * @description:
 * @author: 15506
 * @date: 2024/2/21 8:58
 */
public class UserLoginResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
