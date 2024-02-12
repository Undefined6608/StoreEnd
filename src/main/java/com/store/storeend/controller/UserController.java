package com.store.storeend.controller;

import com.store.storeend.parameter.request.UserRegisterRequest;
import com.store.storeend.parameter.request.roles.RequestRoles;
import com.store.storeend.parameter.response.base.BaseResponse;
import com.store.storeend.parameter.response.base.DefaultStatus;
import com.store.storeend.service.UserService;
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

    @PostMapping("/register")
    public BaseResponse<String> Register(@RequestBody UserRegisterRequest userRegisterRequest) {
        // 格式判定
        if (RequestRoles.UserRegisterRoles(userRegisterRequest)) return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Parameter error!");
        // 密码和验证密码判定
        if (userRegisterRequest.getPassword().equals(userRegisterRequest.getVerPassword())) return BaseResponse.with(DefaultStatus.PARAM_ERROR, "Password verification error!");
        //
        return new BaseResponse<>("login was successful");
    }
}
