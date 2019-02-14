package com.poppy.admin.controller;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-02-14 14:22
 **/

import com.alibaba.fastjson.JSON;
import com.poppy.admin.dao.UserMapper;
import com.poppy.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public String test() {
        User user = userMapper.selectByPrimaryKey(1L);
        return JSON.toJSONString(user);
    }
}
