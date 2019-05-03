package com.cn.tianxia.admin.service.txdata.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.service.txdata.CagentService;

/**
 * 
 * @ClassName CagentServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:13:59
 * @version 1.0.0
 */
@Service
public class CagentServiceImpl implements CagentService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentServiceImpl.class);
    
    @Autowired
    private CagentMapper cagentMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Cagent record) {
        return cagentMapper.insertSelective(record);
    }

    @Override
    public Cagent selectByPrimaryKey(Integer id) {
        return cagentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cagent record) {
        return cagentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<Cagent> list(Map<String, String> params) {
        Pager<Cagent> pager = new Pager<>(params);
        //根据条件查询用户列表
        List<Cagent> users = cagentMapper.findAllByPage(pager);
        //根据条件查询用户总条数
        int totalCounts = cagentMapper.getCagentTotalCounts(pager);
        //总条数
        Pager<Cagent> result = new Pager<>(totalCounts, pager.getPage(), pager.getLimit());
        result.setList(users);
        return result;
    }

    @Override
    public List<Cagent> getCagentSelectList(Pager<Cagent> pager) {
        //查询平台选择列表
        List<Cagent> cagents = cagentMapper.findAllByPage(pager);
        return cagents;
    }

}
