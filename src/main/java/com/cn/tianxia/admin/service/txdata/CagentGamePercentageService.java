package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;

public interface CagentGamePercentageService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentGamePercentage record);

    CagentGamePercentage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentGamePercentage record);
}
