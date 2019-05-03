package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;

public interface CagentQrcodepayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentQrcodepay record);

    int insertSelective(CagentQrcodepay record);

    CagentQrcodepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentQrcodepay record);

    int updateByPrimaryKey(CagentQrcodepay record);
}