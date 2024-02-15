package com.store.storeend.service;

import com.store.storeend.enums.RedisEnum;
import com.store.storeend.util.RedisUtil;
import com.store.storeend.util.VerificationCodeUtil;
import com.store.storeend.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;


@Service
public class VerifyCodeService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private VerifyCode vc;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private VerificationCodeUtil codeGenerator;

    @Value("${spring.mail.username}")
    private String username;

    public BufferedImage verifyImg() {
        BufferedImage image = vc.getImage();
        String verifyCode = vc.getText();
        // 将验证码存入redis
        redisUtil.set(verifyCode, RedisEnum.IMAGE_CODE, 5 * 60);
        return image;
    }

    public Boolean sendEmailCode(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = codeGenerator.generateCode();
        message.setFrom(username);
        message.setTo(to);
        message.setSubject("Verification Code");
        message.setText("Hello!\n" +
                "Your verification code is: " + code + "\n" +
                "This verification code is valid for 5 minutes.\n" +
                "If it is not your own operation, please disregard this email.");
        emailSender.send(message);
        // 将验证码存入redis
        redisUtil.set(code, RedisEnum.EMAIL_CODE + "-" + to, 5 * 60);
        return true;
    }
}
