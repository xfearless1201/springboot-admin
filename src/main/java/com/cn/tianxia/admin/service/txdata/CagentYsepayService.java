package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentYsepay;

public interface CagentYsepayService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentYsepay record);

    CagentYsepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentYsepay record);

}
