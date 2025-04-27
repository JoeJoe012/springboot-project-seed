package com.company.demo.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageParam;
import com.company.demo.core.Result;
import com.company.demo.core.ResultGenerator;
import com.company.demo.entity.User;
import com.company.demo.service.UserService;
import com.company.demo.util.PageUtil;
import com.company.demo.vo.UserInfoVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/userInfo")
    public UserInfoVo queryUserInfo() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setId(1);
        userInfoVo.setUsername("admin");
        userInfoVo.setPassword("123456");
        return userInfoVo;
    }

    @ResponseBody
    @GetMapping("/userInfo/page")
    public Result<List<UserInfoVo>> queryUserInfoPage(PageParam pageParam) {
        PageUtil.startPage(pageParam);
        List<User> allUsers = userService.getAllUsers();
        return ResultGenerator.genSuccess(BeanUtil.copyToList(allUsers, UserInfoVo.class));
    }

}
