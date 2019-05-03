package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;

public interface CagentOnlinememService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentOnlinemem record);

    CagentOnlinemem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentOnlinemem record);

}
