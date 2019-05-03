package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.Cagent;

public interface CagentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cagent record);

    int insertSelective(Cagent record);

    Cagent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cagent record);

    int updateByPrimaryKey(Cagent record);
    
    List<Cagent> findAllByPage(Pager<Cagent> pager);
    //根据条件查询用户总条数
    int getCagentTotalCounts(Pager<Cagent> pager);
    
}