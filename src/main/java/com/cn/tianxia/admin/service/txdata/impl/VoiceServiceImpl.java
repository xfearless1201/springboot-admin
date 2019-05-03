package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.tianxia.admin.domain.txdata.VoiceMapper;
import com.cn.tianxia.admin.project.txdata.Voice;
import com.cn.tianxia.admin.service.txdata.VoiceService;


public class VoiceServiceImpl implements VoiceService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(VoiceServiceImpl.class);
    
    @Autowired
    private VoiceMapper voiceMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return voiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Voice record) {
        return voiceMapper.insertSelective(record);
    }

    @Override
    public Voice selectByPrimaryKey(Integer id) {
        return voiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Voice record) {
        return voiceMapper.updateByPrimaryKeySelective(record);
    }

}
