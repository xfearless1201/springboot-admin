package com.cn.tianxia.admin.service.txdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.Cagent;

public interface CagentService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Cagent record);

    Cagent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cagent record);
    
    Pager<Cagent> list(Map<String,String> params);
    
    List<Cagent> getCagentSelectList(Pager<Cagent> pager);
}
