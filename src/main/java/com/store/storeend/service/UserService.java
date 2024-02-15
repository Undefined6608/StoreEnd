package com.store.storeend.service;

import com.store.storeend.entity.SysUser;
import com.store.storeend.repository.UserRepository;
import com.store.storeend.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<SysUser> getUserList(){
        return userRepository.findAll();
    }

}
