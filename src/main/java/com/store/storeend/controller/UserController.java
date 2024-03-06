package com.store.storeend.controller;

import com.store.storeend.parameter.request.*;
import com.store.storeend.parameter.request.roles.RequestRoles;
import com.store.storeend.parameter.response.UserLoginResponse;
import com.store.storeend.parameter.response.base.BaseResponse;
import com.store.storeend.parameter.response.base.DefaultStatus;
import com.store.storeend.service.UserService;
import com.store.storeend.util.PasswordTools;
import com.store.storeend.util.VerificationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Controller annotations
@RestController
// cross-domain
@CrossOrigin
// Request pre address
@RequestMapping("/user")
// User related controllers
public class UserController {
    /**
     * Register Controller
     */
    @Autowired
    private UserService userService;

    @Autowired
    private VerificationCodeUtil verificationCodeUtil;

    @PostMapping("/user-name_plagiarism_check")
    public BaseResponse<String> userNamePlagiarism(@RequestBody UserNamePlagiarismRequest userNamePlagiarismRequest) {
        if (RequestRoles.UserNamePlagiarismRoles(userNamePlagiarismRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Username format error!");
        if (userService.userNamePlagiarism(userNamePlagiarismRequest.getUserName()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "The username already exists!");
        return new BaseResponse<>();
    }

    @PostMapping("/phone_plagiarism_check")
    public BaseResponse<String> phonePlagiarism(@RequestBody PhonePlagiarismRequest phonePlagiarismRequest) {
        if (RequestRoles.PhonePlagiarismRoles(phonePlagiarismRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Phone number format error!");
        if (userService.phoneNumberPlagiarism(phonePlagiarismRequest.getPhone()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Phone number already exists!");
        return new BaseResponse<>();
    }

    @PostMapping("/email_plagiarism_check")
    public BaseResponse<Boolean> emailPlagiarism(@RequestBody EmailPlagiarismRequest emailPlagiarismRequest) {
        if (RequestRoles.EmailPlagiarismRoles(emailPlagiarismRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Email format error!");
        if (userService.emailPlagiarism(emailPlagiarismRequest.getEmail()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Email already exists!");
        return new BaseResponse<>(true);
    }

    @PostMapping("/register")
    public BaseResponse<String> Register(@RequestBody UserRegisterRequest userRegisterRequest) {
        // 格式判定
        if (RequestRoles.UserRegisterRoles(userRegisterRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Parameter error!");
        // 图形验证码判定
        if (verificationCodeUtil.verifyImgCode(userRegisterRequest.getImgCode()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Graphics verification code from error!");
        // 邮箱验证码判定
        if (verificationCodeUtil.verifyEmailCode(userRegisterRequest.getEmailCode(), userRegisterRequest.getEmail()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Email verification code from error");
        // 密码和验证密码判定
        if (!userRegisterRequest.getPassword().equals(userRegisterRequest.getVerPassword()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Password verification error!");
        // 验证用户名是否已存在
        if (userService.userNamePlagiarism(userRegisterRequest.getUserName()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "The username already exists!");
        // 验证电话号码是否已存在
        if (userService.phoneNumberPlagiarism(userRegisterRequest.getPhone()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Phone number already exists!");
        // 验证邮箱是否已存在
        if (userService.emailPlagiarism(userRegisterRequest.getEmail()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Email already exists!");
        // 将密码加密
        userRegisterRequest.setPassword(PasswordTools.encryption(userRegisterRequest.getPassword()));
        // 将数据存入数据库
        Boolean status = userService.register(userRegisterRequest);
        if (!status) return BaseResponse.with(DefaultStatus.PARAM_ERROR, "register failed");
        return new BaseResponse<>("login was successful");
    }

    @PostMapping("/phone_login")
    public BaseResponse<UserLoginResponse> phoneLogin(@RequestBody UserPhoneLoginRequest userPhoneLoginRequest) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        // 参数格式判定
        if (RequestRoles.PhoneLoginRoles(userPhoneLoginRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Parameter error!");
        // 图像验证码判定
        if (verificationCodeUtil.verifyImgCode(userPhoneLoginRequest.getImgCode()))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Graphics verification code from error!");
        // 用户状态判定
        if (userService.userStatus(userPhoneLoginRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "The user does not exist or has been logged out!");
        // 密码验证
        if (userService.verifyPassword(userPhoneLoginRequest))
            return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Password error!");
        // 生成Token
        String token = userService.phoneLoginToken(userPhoneLoginRequest);
        if (token.isEmpty()) return BaseResponse.with(DefaultStatus.FAILURE,"Unknown error, please contact the administrator!");
        userLoginResponse.setToken(token);
        return new BaseResponse<>(userLoginResponse);
    }
}
