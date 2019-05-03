package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.UserPlatformReport;

public interface UserPlatformReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPlatformReport record);

    int insertSelective(UserPlatformReport record);

    UserPlatformReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPlatformReport record);

    int updateByPrimaryKey(UserPlatformReport record);

	List<UserPlatformReport> selectByUid(Integer uid);
}