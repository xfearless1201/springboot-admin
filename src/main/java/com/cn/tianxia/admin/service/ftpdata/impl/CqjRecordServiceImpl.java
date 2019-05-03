package com.cn.tianxia.admin.service.ftpdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.ftpdata.CqjRecordMapper;
import com.cn.tianxia.admin.project.ftpdata.CqjRecord;
import com.cn.tianxia.admin.service.ftpdata.CqjRecordService;

@Service
public class CqjRecordServiceImpl implements CqjRecordService {

    private static final Logger logger = LoggerFactory.getLogger(CqjRecordServiceImpl.class);
    
    @Autowired
    private CqjRecordMapper cqjRecordMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cqjRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CqjRecord record) {
        return cqjRecordMapper.insertSelective(record);
    }

    @Override
    public CqjRecord selectByPrimaryKey(Integer id) {
        return cqjRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CqjRecord record) {
        return cqjRecordMapper.updateByPrimaryKeySelective(record);
    }

}
