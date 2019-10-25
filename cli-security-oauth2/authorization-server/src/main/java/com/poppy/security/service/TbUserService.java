package com.poppy.security.service;

import com.poppy.security.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        TbUser tbUser = new TbUser();
        tbUser.setId(13L);
        tbUser.setUsername("user");
        tbUser.setPassword("1q2w3e");
        return tbUser;
    }
}