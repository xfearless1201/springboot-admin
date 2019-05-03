package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentGamePercentageMapper;
import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;
import com.cn.tianxia.admin.service.txdata.CagentGamePercentageService;

@Service
public class CagentGamePercentageServiceImpl implements CagentGamePercentageService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentGamePercentageServiceImpl.class);
    
    @Autowired
    private CagentGamePercentageMapper cagentGamePercentageMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentGamePercentageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentGamePercentage record) {
        return cagentGamePercentageMapper.insertSelective(record);
    }

    @Override
    public CagentGamePercentage selectByPrimaryKey(Integer id) {
        return cagentGamePercentageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentGamePercentage record) {
        return cagentGamePercentageMapper.updateByPrimaryKeySelective(record);
    }

}
