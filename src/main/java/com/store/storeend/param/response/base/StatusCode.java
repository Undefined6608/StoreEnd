package com.store.storeend.param.response.base;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public interface StatusCode extends Serializable {
    @JsonValue
    int code();
    String message();
}
