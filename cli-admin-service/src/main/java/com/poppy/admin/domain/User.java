package com.poppy.admin.domain;

import java.util.Date;

public class User {
    private Long id;

    private String avatar;

    private Date create_time;

    private String email;

    private Long enabled;

    private String password;

    private String username;

    private Date last_password_reset_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getLast_password_reset_time() {
        return last_password_reset_time;
    }

    public void setLast_password_reset_time(Date last_password_reset_time) {
        this.last_password_reset_time = last_password_reset_time;
    }
}