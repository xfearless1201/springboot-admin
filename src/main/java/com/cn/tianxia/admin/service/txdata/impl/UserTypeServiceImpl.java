package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.UserTypeMapper;
import com.cn.tianxia.admin.project.txdata.UserType;
import com.cn.tianxia.admin.service.txdata.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserTypeServiceImpl.class);
    
    @Autowired
    private UserTypeMapper userTypeMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserType record) {
        return userTypeMapper.insertSelective(record);
    }

    @Override
    public UserType selectByPrimaryKey(Integer id) {
        return userTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserType record) {
        return userTypeMapper.updateByPrimaryKeySelective(record);
    }

}
