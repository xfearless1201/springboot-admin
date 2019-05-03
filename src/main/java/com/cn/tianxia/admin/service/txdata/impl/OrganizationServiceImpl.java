package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.OrganizationMapper;
import com.cn.tianxia.admin.project.txdata.Organization;
import com.cn.tianxia.admin.service.txdata.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    
    @Autowired
    private OrganizationMapper organizationMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Organization record) {
        return organizationMapper.insertSelective(record);
    }

    @Override
    public Organization selectByPrimaryKey(Long id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Organization record) {
        return organizationMapper.updateByPrimaryKeySelective(record);
    }

}
