package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentGamePercentage;

public interface CagentGamePercentageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentGamePercentage record);

    int insertSelective(CagentGamePercentage record);

    CagentGamePercentage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentGamePercentage record);

    int updateByPrimaryKey(CagentGamePercentage record);
}