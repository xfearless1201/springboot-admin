package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.PlatformConfig;

public interface PlatformConfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PlatformConfig record);

    PlatformConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatformConfig record);

}
