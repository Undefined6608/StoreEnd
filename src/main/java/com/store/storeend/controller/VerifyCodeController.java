package com.store.storeend.controller;

import com.store.storeend.parameter.request.SendEmailRequest;
import com.store.storeend.parameter.request.roles.RequestRoles;
import com.store.storeend.parameter.response.base.BaseResponse;
import com.store.storeend.parameter.response.base.DefaultStatus;
import com.store.storeend.parameter.response.base.StatusCode;
import com.store.storeend.service.VerifyCodeService;
import com.store.storeend.util.VerifyCode;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/verify_code")
// 验证码控制器
public class VerifyCodeController {
    @Autowired
    private VerifyCodeService verifyCodeService;

    @GetMapping(value = "/verify_img")
    public BaseResponse<String> verifyImg() throws IOException {
        // 生成验证码图片
        BufferedImage image = verifyCodeService.verifyImg();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        VerifyCode.output(image, bos);
        // 将图像字节数组转换成 Base64 编码的字符串
        String base64EncodedImage = Base64.encodeBase64String(bos.toByteArray());
        // 返回 Base64 编码的字符串
        return new BaseResponse<>("data:image/PNG;base64," + base64EncodedImage);
    }

    @PostMapping("/send_email")
    public BaseResponse<String> sendEmailCode(@RequestBody SendEmailRequest sendEmailRequest){
        if (RequestRoles.SendEmailRoles(sendEmailRequest)) return BaseResponse.with(DefaultStatus.PARAM_ERROR,"Email format error!");
        if (!verifyCodeService.sendEmailCode(sendEmailRequest.getEmail())) return BaseResponse.with(DefaultStatus.PARAM_ERROR,"Email sending failed!");
        return new BaseResponse<>("Email sent successfully");
    }
}
