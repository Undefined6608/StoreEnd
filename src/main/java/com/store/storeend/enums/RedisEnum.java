package com.store.storeend.enums;

public enum RedisEnum {
    IMAGE_CODE("image_code"),
    EMAIL_CODE("email_code"),
    ;
    private final String key;

    RedisEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
