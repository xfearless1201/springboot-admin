package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentMsgconfig;

public interface CagentMsgconfigService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentMsgconfig record);

    CagentMsgconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentMsgconfig record);

}
