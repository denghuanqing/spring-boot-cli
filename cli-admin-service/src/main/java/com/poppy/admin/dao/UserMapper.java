package com.poppy.admin.dao;

import com.poppy.admin.domain.User;
import com.poppy.admin.domain.UserExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}