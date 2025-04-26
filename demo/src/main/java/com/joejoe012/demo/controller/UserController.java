package com.joejoe012.demo.controller;

import cn.hutool.system.UserInfo;
import com.github.pagehelper.PageParam;
import com.joejoe012.demo.entity.User;
import com.joejoe012.demo.service.UserService;
import com.joejoe012.demo.util.PageUtil;
import com.joejoe012.demo.util.R;
import com.joejoe012.demo.vo.UserInfoVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public R<List<UserInfoVo>> queryUserInfoPage(PageParam pageParam) {
        PageUtil.startPage(pageParam);
        List<User> allUsers = userService.getAllUsers();
        return R.buildPageToVoSuccess(allUsers, UserInfoVo.class);
    }
}
