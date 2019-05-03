package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformConfig;

public interface PlatformConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatformConfig record);

    int insertSelective(PlatformConfig record);

    PlatformConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformConfig record);

    int updateByPrimaryKey(PlatformConfig record);
}