package com.store.storeend.parameter.request;

import org.springframework.stereotype.Component;

/**
 * @className: PhoneNamePlagiarism
 * @description:
 * @author: 15506
 * @date: 2024/2/15 16:07
 */
@Component
public class PhonePlagiarismRequest {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhoneNamePlagiarism{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
