package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

/**
 * @className: SendEmailRequest
 * @description:
 * @author: 15506
 * @date: 2024/2/12 23:27
 */
@Component
public class SendEmailRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SendEmailRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
