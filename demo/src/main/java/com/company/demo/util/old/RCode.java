package com.company.demo.util.old;

import lombok.Getter;

@Getter
public enum RCode {
    SUCCESS(0, "success"),
    ERROR(-1, "error");

    private final Integer code;
    private final String message;
    RCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
