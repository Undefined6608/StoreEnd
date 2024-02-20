package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

/**
 * @className: UserNamePlagiarism
 * @description:
 * @author: 15506
 * @date: 2024/2/15 16:06
 */
@Component
public class UserNamePlagiarismRequest {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserNamePlagiarism{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
