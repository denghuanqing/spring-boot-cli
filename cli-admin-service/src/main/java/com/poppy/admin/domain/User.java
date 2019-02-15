package com.poppy.admin.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Data
public class User {
    private Long id;

    private String avatar;

    private Date create_time;

    private String email;

    private boolean enabled;

    private String password;

    private String username;

    private Date last_password_reset_time;

    private Timestamp createTime;

    private Date lastPasswordResetTime;

    private Set<Role> roles;

}