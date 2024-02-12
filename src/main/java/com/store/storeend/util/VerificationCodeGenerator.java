package com.store.storeend.util;

import org.springframework.stereotype.Component;
import java.util.Random;

/**
 * @className: VerificationCodeGenerator
 * @description:
 * @author: 15506
 * @date: 2024/2/12 23:38
 */

@Component
public class VerificationCodeGenerator {
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
}
