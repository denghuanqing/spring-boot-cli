package com.poppy.security.mapper;

import com.poppy.security.common.MyMapper;
import com.poppy.security.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}