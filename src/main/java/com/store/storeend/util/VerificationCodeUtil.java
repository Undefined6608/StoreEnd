package com.store.storeend.util;

import com.store.storeend.enums.RedisEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @className: VerificationCodeGenerator
 * @description:
 * @author: 15506
 * @date: 2024/2/12 23:38
 */

@Component
public class VerificationCodeUtil {
    @Autowired
    private RedisUtil redisUtil;
    // 长度为 6
    private static final int CODE_LENGTH = 6;

    public String generateCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    public boolean verifyImgCode(String imgCode) {
        Object obj = redisUtil.get(imgCode);
        if (obj == null) return true;
        return !obj.equals(RedisEnum.IMAGE_CODE.toString());
    }

    public boolean verifyEmailCode(String emailCode, String email) {
        Object obj = redisUtil.get(emailCode);
        if (obj == null) return true;
        return !obj.equals(RedisEnum.EMAIL_CODE + "-" + email);
    }
}
