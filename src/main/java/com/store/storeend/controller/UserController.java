package com.store.storeend.controller;

import com.store.storeend.param.request.user.RegisterBody;
import com.store.storeend.param.response.base.BaseResponse;
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
     * @return message
     */
    @PostMapping("/register")
    public BaseResponse<RegisterBody> Register(@RequestBody RegisterBody registerBody) {
        return new BaseResponse<>(registerBody);
    }
}
