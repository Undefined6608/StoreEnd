package com.store.storeend.enums;

public enum RegularEnum {
    // 用户名正则
    USER_NAME("^[a-zA-Z0-9_-]{3,16}$"),
    // 密码正则
    PASSWORD("^[0-9a-fA-F]{32}$"),
    // 邮箱正则
    EMAIL("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"),
    // 电话号码正则
    PHONE("^1[3-9]\\d{9}$"),
    // 邮箱验证码正则，6位数字
    EMAIL_CODE("^\\d{6}$"),
    // 图像验证码
    IMG_CODE("^[a-zA-Z0-9]{6}$"),
    // 性别
    GENDER("^[01]$"),
    // 头像
    AVATAR("^(https?|ftp):\\/\\/[^\\s\\/$.?#].[^\\s]*$");

    private final String value;
    RegularEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ParameterRegularization{" +
                "value='" + value + '\'' +
                '}';
    }
}
