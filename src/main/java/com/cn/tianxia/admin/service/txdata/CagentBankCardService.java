package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentBankCard;

public interface CagentBankCardService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentBankCard record);

    CagentBankCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentBankCard record);

}
