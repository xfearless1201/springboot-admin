package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentOnlinemem;

public interface CagentOnlinememMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentOnlinemem record);

    int insertSelective(CagentOnlinemem record);

    CagentOnlinemem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentOnlinemem record);

    int updateByPrimaryKey(CagentOnlinemem record);
}