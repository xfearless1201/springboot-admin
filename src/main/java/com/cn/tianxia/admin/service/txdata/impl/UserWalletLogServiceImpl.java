package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.tianxia.admin.domain.txdata.UserWalletLogMapper;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;
import com.cn.tianxia.admin.service.txdata.UserWalletLogService;


public class UserWalletLogServiceImpl implements UserWalletLogService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserWalletLogServiceImpl.class);
    
    @Autowired
    private UserWalletLogMapper userWalletLogMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userWalletLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserWalletLog record) {
        return userWalletLogMapper.insertSelective(record);
    }

    @Override
    public UserWalletLog selectByPrimaryKey(Integer id) {
        return userWalletLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserWalletLog record) {
        return userWalletLogMapper.updateByPrimaryKeySelective(record);
    }

}
