package com.poppy.security.service;

import com.poppy.security.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        return null;
    }
}