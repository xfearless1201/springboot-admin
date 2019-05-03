package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;

public interface CagentMsgconfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentMsgconfig record);

    int insertSelective(CagentMsgconfig record);

    CagentMsgconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentMsgconfig record);

    int updateByPrimaryKey(CagentMsgconfig record);
}