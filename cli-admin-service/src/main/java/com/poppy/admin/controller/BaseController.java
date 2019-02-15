package com.poppy.admin.controller;

import com.poppy.admin.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-02-15 10:19
 **/
public class BaseController {
    public static UserDetails getUserDetails() {
        UserDetails userDetails = null;
        try {
            userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "登录状态过期");
        }
        return userDetails;
    }
}
