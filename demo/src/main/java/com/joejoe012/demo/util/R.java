package com.joejoe012.demo.util;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.joejoe012.demo.constant.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String message;
    private T data;
    private Long total;

    public static <T> R<T> buildSuccess() {
        return new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null, null);
    }
    public static <T> R<T> buildSuccess(Integer code, String msg, T data) {
        return new R<>(code, msg, data, null);
    }
    public static <T> R<T> buildPageSuccess(T data) {
        if (data == null)
            new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null, null);
        long total = new PageInfo<>((List) data).getTotal();
        return new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, total);
    }
    public static <T> R<List<T>> buildPageToVoSuccess(List<?> data, Class<T> clazz) {
        if (data == null)
            new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null, null);
        long total = new PageInfo<>((List) data).getTotal();
        return new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), BeanUtil.copyToList(data, clazz), total);
    }

    public static <T> R<T> buildError() {
        return new R<>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), null, null);
    }
    public static <T> R<T> buildError(Integer code, String msg, T data) {
        return new R<>(code, msg, data, null);
    }
}
