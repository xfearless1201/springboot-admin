package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.InternalMessageMapper;
import com.cn.tianxia.admin.project.txdata.InternalMessage;
import com.cn.tianxia.admin.service.txdata.InternalMessageService;

@Service
public class InternalMessageServiceImpl implements InternalMessageService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(InternalMessageServiceImpl.class);
    
    @Autowired
    private InternalMessageMapper internalMessageMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return internalMessageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(InternalMessage record) {
        return internalMessageMapper.insertSelective(record);
    }

    @Override
    public InternalMessage selectByPrimaryKey(Integer id) {
        return internalMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(InternalMessage record) {
        return internalMessageMapper.updateByPrimaryKeySelective(record);
    }

}
