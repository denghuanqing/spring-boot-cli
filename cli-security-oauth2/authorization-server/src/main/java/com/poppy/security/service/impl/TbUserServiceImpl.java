package com.poppy.security.service.impl;

import com.poppy.security.domain.TbUser;
import com.poppy.security.mapper.TbUserMapper;
import com.poppy.security.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
//        Example example = new Example(TbUser.class);
//        example.createCriteria().andEqualTo("username", username);
//        return tbUserMapper.selectOneByExample(example);

        TbUser tbUser = new TbUser();
        tbUser.setId(13L);
        tbUser.setUsername("poppy");
        tbUser.setPassword("$2a$10$h1cffmWXJ1ngxVchUj7S2OLBxeujFeutHqV8mLmYwcVbwR37vv2Ey");
        return tbUser;

    }
}