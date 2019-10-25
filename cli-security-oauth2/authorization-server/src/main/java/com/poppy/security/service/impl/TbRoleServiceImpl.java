package com.poppy.security.service.impl;

import com.poppy.security.mapper.TbRoleMapper;
import com.poppy.security.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbRoleServiceImpl implements TbRoleService {

    @Resource
    private TbRoleMapper tbRoleMapper;

}