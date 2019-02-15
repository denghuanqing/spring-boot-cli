package com.poppy.admin.controller;

import com.poppy.admin.domain.JwtUser;
import com.poppy.admin.security.AuthenticationToken;
import com.poppy.admin.security.AuthorizationUser;
import com.poppy.admin.utils.EncryptUtils;
import com.poppy.admin.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登陆生成token Controller
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthenticationController extends BaseController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    /**
     * 登录授权
     *
     * @param authorizationUser
     * @return
     */
    @PostMapping(value = "${jwt.auth.path}")
    public ResponseEntity login(@Validated @RequestBody AuthorizationUser authorizationUser) {

        /**
         * 1.校验密码，校验用户状态。
         * 2.生成token
         */
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authorizationUser.getUsername());

        String password = EncryptUtils.encryptPassword(authorizationUser.getPassword());
        if (!userDetails.getPassword().equals(password)) {
            throw new AccountExpiredException("密码错误");
        }

        if (!userDetails.isEnabled()) {
            throw new AccountExpiredException("账号已停用，请联系管理员");
        }

        // 生成令牌
        final String token = jwtTokenUtil.generateToken(userDetails);

        // 返回 token
        return ResponseEntity.ok(new AuthenticationToken(token));
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping(value = "${jwt.auth.account}")
    public ResponseEntity getUserInfo() {
        UserDetails userDetails = getUserDetails();
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok(jwtUser);
    }
}
