package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PlatformStatusMapper;
import com.cn.tianxia.admin.project.txdata.PlatformStatus;
import com.cn.tianxia.admin.service.txdata.PlatformStatusService;

@Service
public class PlatformStatusServiceImpl implements PlatformStatusService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformStatusServiceImpl.class);
    
    @Autowired
    private PlatformStatusMapper platformStatusMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return platformStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformStatus record) {
        return platformStatusMapper.insertSelective(record);
    }

    @Override
    public PlatformStatus selectByPrimaryKey(Integer id) {
        return platformStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformStatus record) {
        return platformStatusMapper.updateByPrimaryKeySelective(record);
    }

}
