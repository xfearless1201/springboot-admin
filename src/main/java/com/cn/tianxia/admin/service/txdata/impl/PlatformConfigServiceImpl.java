package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.PlatformConfigMapper;
import com.cn.tianxia.admin.project.txdata.PlatformConfig;
import com.cn.tianxia.admin.service.txdata.PlatformConfigService;

@Service
public class PlatformConfigServiceImpl implements PlatformConfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(PlatformConfigServiceImpl.class);
    
    @Autowired
    private PlatformConfigMapper platformConfigMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return platformConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformConfig record) {
        return platformConfigMapper.insertSelective(record);
    }

    @Override
    public PlatformConfig selectByPrimaryKey(Integer id) {
        return platformConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformConfig record) {
        return platformConfigMapper.updateByPrimaryKeySelective(record);
    }

    
}
