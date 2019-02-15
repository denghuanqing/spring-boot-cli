package com.poppy.admin.service;

import com.google.common.collect.Sets;
import com.poppy.admin.dao.UserMapper;
import com.poppy.admin.domain.JwtUser;
import com.poppy.admin.domain.Permission;
import com.poppy.admin.domain.Role;
import com.poppy.admin.domain.User;
import com.poppy.admin.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义的用户认证逻辑，从数据库查询用户。 根据用户名查询对应的用户和权限。
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.selectByPrimaryKey(1L);

        /**
         * 手动模拟用户角色
         */
        Role role = new Role();
        Permission permission = new Permission();
        permission.setAlias("test");
        // 控制权限
        permission.setName("ADMIN");
        HashSet<Permission> permissions = Sets.newHashSet(permission);
        role.setPermissions(permissions);
        HashSet<Role> roles = Sets.newHashSet(role);
        user.setRoles(roles);

        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", username);
        } else {
            return create(user);
        }
    }

    public UserDetails create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles()),
                user.isEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> roles) {

        Set<Permission> permissions = new HashSet<>();
        for (Role role : roles) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);
            permissions.addAll(role.getPermissions());
        }

        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority("ROLE_" + permission.getName()))
                .collect(Collectors.toList());
    }
}
