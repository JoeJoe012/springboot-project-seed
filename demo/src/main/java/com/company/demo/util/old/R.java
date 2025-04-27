package com.company.demo.util.old;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
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
        return new R<>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getMessage(), null, null);
    }
    public static <T> R<T> buildSuccess(Integer code, String msg, T data) {
        return new R<>(code, msg, data, null);
    }
    public static <T> R<T> buildPageSuccess(T data) {
        long total = data != null ? new PageInfo<>((List) data).getTotal() : 0L;
        return new R<>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getMessage(), data, total);
    }
    public static <T> R<List<T>> buildPageToVoSuccess(List<?> data, Class<T> clazz) {
        if (data == null)
            new R<>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getMessage(), null, null);
        long total = new PageInfo<>((List) data).getTotal();
        return new R<>(RCode.SUCCESS.getCode(), RCode.SUCCESS.getMessage(), BeanUtil.copyToList(data, clazz), total);
    }

    public static <T> R<T> buildError() {
        return new R<>(RCode.ERROR.getCode(), RCode.ERROR.getMessage(), null, null);
    }
    public static <T> R<T> buildError(Integer code, String msg, T data) {
        return new R<>(code, msg, data, null);
    }
}
