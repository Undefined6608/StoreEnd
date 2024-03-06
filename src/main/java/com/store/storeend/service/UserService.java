package com.store.storeend.service;

import com.store.storeend.entity.SysUser;
import com.store.storeend.parameter.request.UserPhoneLoginRequest;
import com.store.storeend.parameter.request.UserRegisterRequest;
import com.store.storeend.repository.UserRepository;
import com.store.storeend.util.JwtTokenUtil;
import com.store.storeend.util.PasswordTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 用户名查重
     *
     * @param userName 用户名
     * @return 是否重复
     */
    public Boolean userNamePlagiarism(String userName) {
        List<SysUser> userList = userRepository.findByUserName(userName);
        return userList.size() != 0;
    }

    /**
     * 电话号码查重
     *
     * @param phone 电话号码
     * @return 是否重复
     */
    public Boolean phoneNumberPlagiarism(String phone) {
        List<SysUser> userList = userRepository.findByPhone(phone);
        return userList.size() != 0;
    }

    /**
     * 邮箱查重
     *
     * @param email 邮箱
     * @return 是否重复
     */
    public Boolean emailPlagiarism(String email) {
        List<SysUser> userList = userRepository.findByEmail(email);
        return userList.size() != 0;
    }

    /**
     * 注册服务
     *
     * @param request 用户信息
     * @return 是否注册成功
     */
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

    // 用户状态服务
    public Boolean userStatus(UserPhoneLoginRequest userPhoneLoginRequest) {
        List<SysUser> userList = userRepository.findByPhone(userPhoneLoginRequest.getPhone());
        if (userList.size() == 0) return true;
        return !userList.get(0).getEnable();
    }

    // 密码判定
    public Boolean verifyPassword(UserPhoneLoginRequest userPhoneLoginRequest) {
        List<SysUser> userList = userRepository.findByPhone(userPhoneLoginRequest.getPhone());
        if (userList.size() == 0) return true;
        return !PasswordTools.match(userPhoneLoginRequest.getPassword(), userList.get(0).getPassword());
    }

    // 生成Token
    private String createToken(SysUser user) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        return jwtTokenUtil.generateToken(user);
    }

    public String phoneLoginToken(UserPhoneLoginRequest userPhoneLoginRequest){
        List<SysUser> userList = userRepository.findByPhone(userPhoneLoginRequest.getPhone());
        if (userList.size() == 0) return "";
        return createToken(userList.get(0));
    }

    public List<SysUser> getUserList() {
        return userRepository.findAll();
    }

}
