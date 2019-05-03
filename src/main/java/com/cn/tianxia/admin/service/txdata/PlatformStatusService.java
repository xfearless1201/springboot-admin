package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformStatus;

public interface PlatformStatusService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlatformStatus record);

    PlatformStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformStatus record);
}
