package com.poppy.admin.controller;

import com.alibaba.fastjson.JSON;
import com.poppy.admin.dao.UserMapper;
import com.poppy.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping("/test1")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_SELECT')")
    public String test1() {
        User user = userMapper.selectByPrimaryKey(1L);
        return JSON.toJSONString(user);
    }

    @ResponseBody
    @RequestMapping("/test2")
    @PreAuthorize("hasAnyRole('ROLES_ALL','ROLES_SELECT')")
    public String test2() {
        User user = userMapper.selectByPrimaryKey(1L);
        return JSON.toJSONString(user);
    }
}
