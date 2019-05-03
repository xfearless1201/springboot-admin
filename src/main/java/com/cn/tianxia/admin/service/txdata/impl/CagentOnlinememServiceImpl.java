package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentOnlinememMapper;
import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;
import com.cn.tianxia.admin.service.txdata.CagentOnlinememService;

/**
 * 
 * @ClassName CagentOnlinememServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:44:18
 * @version 1.0.0
 */
@Service
public class CagentOnlinememServiceImpl implements CagentOnlinememService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentOnlinememServiceImpl.class);
    
    @Autowired
    private CagentOnlinememMapper cagentOnlinememMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentOnlinememMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentOnlinemem record) {
        return cagentOnlinememMapper.insertSelective(record);
    }

    @Override
    public CagentOnlinemem selectByPrimaryKey(Integer id) {
        return cagentOnlinememMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentOnlinemem record) {
        return cagentOnlinememMapper.updateByPrimaryKeySelective(record);
    }

}
