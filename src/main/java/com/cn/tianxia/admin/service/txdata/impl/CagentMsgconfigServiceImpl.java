package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;
import com.cn.tianxia.admin.service.txdata.CagentMsgconfigService;

/**
 * 
 * @ClassName CagentMsgconfigServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:36:02
 * @version 1.0.0
 */
@Service
public class CagentMsgconfigServiceImpl implements CagentMsgconfigService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentMsgconfigServiceImpl.class);
    
    @Autowired
    private CagentMsgconfigService cagentMsgconfigService;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentMsgconfigService.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentMsgconfig record) {
        return cagentMsgconfigService.insertSelective(record);
    }

    @Override
    public CagentMsgconfig selectByPrimaryKey(Integer id) {
        return cagentMsgconfigService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentMsgconfig record) {
        return cagentMsgconfigService.updateByPrimaryKeySelective(record);
    }

}
