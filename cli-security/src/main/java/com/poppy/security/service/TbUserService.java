package com.poppy.security.service;

import com.poppy.security.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        TbUser tbUser = new TbUser();
        tbUser.setId(13L);
        tbUser.setUsername("poppy");
        tbUser.setPassword("$2a$10$h1cffmWXJ1ngxVchUj7S2OLBxeujFeutHqV8mLmYwcVbwR37vv2Ey");
        return tbUser;
    }
}