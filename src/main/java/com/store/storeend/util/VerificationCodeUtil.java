package com.store.storeend.util;

import com.store.storeend.enums.RedisEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        List<Object> list = redisUtil.lGet(imgCode);
        if (list.size() == 0) return true;
        for (Object o : list)
            return !o.equals(RedisEnum.IMAGE_CODE);
        return true;
    }

    public boolean verifyEmailCode(String emailCode, String email) {
        List<Object> list = redisUtil.lGet(emailCode);
        if (list.size() == 0) return true;
        for (Object o : list)
            return !o.equals(RedisEnum.EMAIL_CODE + "-" + email);
        return true;
    }
}
