package com.company.demo.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageParam;

public class PageUtil {
    public static void startPage(PageParam pageParam) {
        int pageNum = pageParam.getPageNum() != null ? pageParam.getPageNum() : 1;
        int pageSize = pageParam.getPageSize() != null ? pageParam.getPageSize() : 10;
        String order = pageParam.getOrderBy();
        if (order != null && !order.isBlank())
            PageHelper.startPage(pageNum, pageSize, order);
        else
            PageHelper.startPage(pageNum, pageSize);
    }
}
