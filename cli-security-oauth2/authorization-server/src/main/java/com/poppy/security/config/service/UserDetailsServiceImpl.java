package com.poppy.security.config.service;

import com.google.common.collect.Lists;
import com.poppy.security.domain.User;
import com.poppy.security.service.TbPermissionService;
import com.poppy.security.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-10-15 17:49
 **/
@Slf4j
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TbUser tbUser = tbUserService.getByUsername(username);

        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(1);
        user.setId("1112112122");
        user.setUserName("user");
        user.setPassword("1q2w3e");


        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//        if (tbUser != null) {
//            // 获取用户授权
////            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
//            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
//
//            // 声明用户授权
//            tbPermissions.forEach(tbPermission -> {
//                if (tbPermission != null && tbPermission.getEnname() != null) {
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
//                    grantedAuthorities.add(grantedAuthority);
//                }
//            });
//
//            String permission = tbPermissions.stream().map(TbPermission::getEnname).collect(Collectors.joining(","));
//            log.info("grand user:{}", permission);
//        }

        ArrayList<String> permission = Lists.newArrayList();
        permission.add("ROLE_USER");

        return new CustomUserDetails(user, permission);
    }
}
