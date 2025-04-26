package com.joejoe012.demo.constant;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(0, "success"),
    ERROR(-1, "error");

    private final Integer code;
    private final String message;
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
