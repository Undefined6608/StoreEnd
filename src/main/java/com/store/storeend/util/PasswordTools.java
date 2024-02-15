package com.store.storeend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @className: PasswordTool
 * @description:
 * @author: 15506
 * @date: 2024/2/14 16:11
 */
@Component
public class PasswordTools {
    @Value("${spring.private-key.password}")
    private static String privateKey;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 密码加密
     * @param raw 加密前字符串
     * @return 加密后字符串
     */
    public static String encryption(String raw) {
        return passwordEncoder.encode(raw + privateKey);
    }

    /**
     * 密码验证
     * @param raw 需要验证的字符串
     * @param encoded 加密后的字符串
     * @return 结果
     */
    public static boolean match(String raw, String encoded) {
        return passwordEncoder.matches(raw + privateKey, encoded);
    }
}
