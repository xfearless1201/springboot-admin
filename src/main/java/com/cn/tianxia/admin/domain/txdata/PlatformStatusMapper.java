package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformStatus;

public interface PlatformStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatformStatus record);

    int insertSelective(PlatformStatus record);

    PlatformStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformStatus record);

    int updateByPrimaryKey(PlatformStatus record);
}