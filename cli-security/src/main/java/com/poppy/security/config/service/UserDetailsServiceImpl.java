package com.poppy.security.config.service;

import com.google.common.collect.Lists;
import com.poppy.security.domain.CustomUserDetails;
import com.poppy.security.domain.TbPermission;
import com.poppy.security.domain.TbUser;
import com.poppy.security.service.TbPermissionService;
import com.poppy.security.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(username);

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
        return new CustomUserDetails(tbUser,permission);
//        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
