package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;

public interface CagentQrcodepayService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentQrcodepay record);

    CagentQrcodepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentQrcodepay record);

}
