package com.store.storeend.service;

import com.store.storeend.entity.SysUser;
import com.store.storeend.parameter.request.UserRegisterRequest;
import com.store.storeend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Boolean userNamePlagiarism(String userName) {
        List<SysUser> userList = userRepository.findByUserName(userName);
        return userList.size() != 0;
    }

    public Boolean phoneNumberPlagiarism(String phone) {
        List<SysUser> userList = userRepository.findByPhone(phone);
        return userList.size() != 0;
    }

    public Boolean emailPlagiarism(String email) {
        List<SysUser> userList = userRepository.findByEmail(email);
        return userList.size() != 0;
    }

    public Boolean register(UserRegisterRequest request) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(request.getUserName());
        sysUser.setPassword(request.getPassword());
        sysUser.setEmail(request.getEmail());
        sysUser.setPhone(request.getPhone());
        sysUser.setGender(!request.getGender().equals("0"));
        sysUser.setLimit(3);
        sysUser.setAvatar(request.getAvatar());
        sysUser.setIntegral(0);
        sysUser.setBalance(0);
        sysUser.setEnable(true);
        sysUser.setLike(0);
        sysUser.setDontLike(0);
        sysUser.setUid(UUID.randomUUID().toString());
        System.out.println(sysUser);
        SysUser save = userRepository.save(sysUser);
        return !save.getUid().equals("");
    }

    public List<SysUser> getUserList() {
        return userRepository.findAll();
    }

}
