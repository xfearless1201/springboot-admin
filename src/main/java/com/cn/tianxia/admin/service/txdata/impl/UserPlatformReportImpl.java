package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserPlatformReportMapper;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;
import com.cn.tianxia.admin.service.txdata.UserPlatformReportService;

@Service
public class UserPlatformReportImpl implements UserPlatformReportService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserPlatformReportImpl.class);
    
    @Autowired
    private UserPlatformReportMapper userPlatformReportMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userPlatformReportMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserPlatformReport record) {
        return userPlatformReportMapper.insertSelective(record);
    }

    @Override
    public UserPlatformReport selectByPrimaryKey(Integer id) {
        return userPlatformReportMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPlatformReport record) {
        return userPlatformReportMapper.updateByPrimaryKeySelective(record);
    }

}
