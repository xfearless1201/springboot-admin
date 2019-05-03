package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserPlatformReport;

public interface UserPlatformReportService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPlatformReport record);

    UserPlatformReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPlatformReport record);
}
