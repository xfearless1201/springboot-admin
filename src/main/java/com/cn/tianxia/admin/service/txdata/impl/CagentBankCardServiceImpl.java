package com.cn.tianxia.admin.service.txdata.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.domain.txdata.CagentBankCardMapper;
import com.cn.tianxia.admin.project.txdata.CagentBankCard;
import com.cn.tianxia.admin.service.txdata.CagentBankCardService;

/**
 * 
 * @ClassName CagentBankCardServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Hardy
 * @Date 2019年4月22日 下午3:15:57
 * @version 1.0.0
 */
@Service
public class CagentBankCardServiceImpl implements CagentBankCardService {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CagentBankCardServiceImpl.class);
    
    @Autowired
    private CagentBankCardMapper cagentBankCardMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cagentBankCardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CagentBankCard record) {
        return cagentBankCardMapper.insertSelective(record);
    }

    @Override
    public CagentBankCard selectByPrimaryKey(Integer id) {
        return cagentBankCardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CagentBankCard record) {
        return cagentBankCardMapper.updateByPrimaryKeySelective(record);
    }

}
