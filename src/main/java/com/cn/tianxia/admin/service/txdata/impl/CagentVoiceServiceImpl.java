package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentVoiceMapper;
import com.cn.tianxia.admin.project.txdata.CagentVoice;
import com.cn.tianxia.admin.service.txdata.CagentVoiceService;

@Service
public class CagentVoiceServiceImpl implements CagentVoiceService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentVoiceServiceImpl.class);
    
    @Autowired
    private CagentVoiceMapper cagentVoiceMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentVoiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentVoice record) {
        return cagentVoiceMapper.insertSelective(record);
    }

    @Override
    public CagentVoice selectByPrimaryKey(Integer id) {
        return cagentVoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentVoice record) {
        return cagentVoiceMapper.updateByPrimaryKeySelective(record);
    }

}
