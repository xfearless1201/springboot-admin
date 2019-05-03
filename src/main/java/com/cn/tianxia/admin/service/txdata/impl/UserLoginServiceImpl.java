package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserLoginMapper;
import com.cn.tianxia.admin.project.txdata.UserLogin;
import com.cn.tianxia.admin.service.txdata.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    
    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    
    @Autowired
    private UserLoginMapper userLoginMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserLogin record) {
        return userLoginMapper.insertSelective(record);
    }

    @Override
    public UserLogin selectByPrimaryKey(Integer id) {
        return userLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLogin record) {
        return userLoginMapper.updateByPrimaryKeySelective(record);
    }

}
