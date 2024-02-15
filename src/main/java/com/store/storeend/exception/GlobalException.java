package com.store.storeend.exception;

import com.store.storeend.parameter.response.base.BaseResponse;
import com.store.storeend.parameter.response.base.DefaultStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @className: GlobalException
 * @description:
 * @author: 15506
 * @date: 2024/2/14 17:51
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleException(Exception ex) {
        return BaseResponse.with(DefaultStatus.PARAM_ERROR, "An error occurred: " + ex.getMessage());
    }
}
