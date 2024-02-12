package com.store.storeend.controller;

import com.store.storeend.parameter.response.base.BaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public BaseResponse<String> hello(){
        return new BaseResponse<>("Hello World!");
    }
}
