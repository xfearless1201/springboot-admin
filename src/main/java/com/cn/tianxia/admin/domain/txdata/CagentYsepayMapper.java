package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentYsepay;

public interface CagentYsepayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentYsepay record);

    int insertSelective(CagentYsepay record);

    CagentYsepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentYsepay record);

    int updateByPrimaryKey(CagentYsepay record);
}