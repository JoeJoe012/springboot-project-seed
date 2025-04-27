package com.joejoe012.demo.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一API响应结果封装
 */
public class Result<T> {
    private int code;
    private String message;
    private T data;
    private Long total;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Result setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Long getTotal() {
        return total;
    }
}
