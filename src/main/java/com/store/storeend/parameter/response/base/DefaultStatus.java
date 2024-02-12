package com.store.storeend.parameter.response.base;

// Response code enumeration class
public enum DefaultStatus implements StatusCode{
    // success status code
    SUCCESS(200, "Operation Success"),
    // parameters error status code
    PARAM_ERROR(400, "Invalid parameters"),
    // authorization error status code
    AUTHORIZATION_ERROR(401, "Authorization Error"),
    // not found error status code
    NOT_FOUND(404, "Resource not found"),
    // failure status code
    FAILURE(500, "Application internal error");

    // Response code
    private final int code;
    // Response message
    private final String message;

    /**
     * Default Status
     * @param code default status code
     * @param message default message
     */
    DefaultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
