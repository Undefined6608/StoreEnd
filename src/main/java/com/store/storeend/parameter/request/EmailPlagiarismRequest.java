package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

/**
 * @className: EmailPlagiarism
 * @description:
 * @author: 15506
 * @date: 2024/2/15 16:09
 */
@Component
public class EmailPlagiarismRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailPlagiarism{" +
                "email='" + email + '\'' +
                '}';
    }
}
