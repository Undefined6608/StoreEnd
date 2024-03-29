package com.store.storeend.parameter.response.base;

import java.io.Serializable;

import static com.store.storeend.parameter.response.base.DefaultStatus.SUCCESS;

public final class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3886133510113334083L;

    private StatusCode code;
    private String message;
    private T data;

    public BaseResponse() {
        this.setCode(SUCCESS);
        this.message = SUCCESS.message();
    }

    public BaseResponse(T data) {
        this();
        this.data = data;
    }

    public StatusCode getCode() {
        return code;
    }

    public BaseResponse<T> setCode(StatusCode code) {
        this.code = code;
        this.message = code.message();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * Only code
     * @param code the code
     * @return the response
     * @param <T> data type
     */
    public static <T> BaseResponse<T> with(StatusCode code){
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = code.message();
        return response;
    }

    /**
     * Only code and message
     * @param code the status code
     * @param message the message
     * @return the response
     * @param <T> data type
     */
    public static <T> BaseResponse<T> with(StatusCode code, String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = message;
        return response;
    }

    /**
     * Only code and data
     * @param code the status code
     * @param data the data
     * @return the response
     * @param <T> data type
     */
    public static <T> BaseResponse<T> with(StatusCode code, T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = code.message();
        response.data = data;
        return response;
    }

    /**
     * all attributes
     * @param code the status code
     * @param message the message
     * @param data the data
     * @return the response
     * @param <T> data type
     */
    public static <T> BaseResponse<T> with(StatusCode code, String message, T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = message;
        response.data = data;
        return response;
    }

    /**
     * Output Properties
     * @return property value string
     */
    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
