package com.store.storeend.parameter.request.roles;

import com.store.storeend.parameter.request.SendEmailRequest;
import com.store.storeend.parameter.request.UserRegisterRequest;
import com.store.storeend.enums.RegularEnum;
import com.store.storeend.util.ParameterTools;
import org.springframework.stereotype.Component;

@Component
public class RequestRoles {
    public static Boolean UserRegisterRoles(UserRegisterRequest userRegisterRequest){
        // 判断参数是否为空
        return !ParameterTools.isRegularization(RegularEnum.USER_NAME.getValue(), userRegisterRequest.getUserName())
                || !ParameterTools.isRegularization(RegularEnum.PASSWORD.getValue(), userRegisterRequest.getPassword())
                || !ParameterTools.isRegularization(RegularEnum.PASSWORD.getValue(), userRegisterRequest.getVerPassword())
                || !ParameterTools.isRegularization(RegularEnum.EMAIL.getValue(), userRegisterRequest.getEmail())
                || !ParameterTools.isRegularization(RegularEnum.PHONE.getValue(), userRegisterRequest.getPhone())
                || !ParameterTools.isRegularization(RegularEnum.EMAIL_CODE.getValue(), userRegisterRequest.getEmailCode())
                || !ParameterTools.isRegularization(RegularEnum.IMG_CODE.getValue(), userRegisterRequest.getImgCode())
                || !ParameterTools.isRegularization(RegularEnum.GENDER.getValue(), userRegisterRequest.getGender())
                || !ParameterTools.isRegularization(RegularEnum.AVATAR.getValue(), userRegisterRequest.getAvatar());
    }

    public static Boolean SendEmailRoles(SendEmailRequest sendEmailRequest){
        return !ParameterTools.isRegularization(RegularEnum.EMAIL.getValue(), sendEmailRequest.getEmail());
    }
}
