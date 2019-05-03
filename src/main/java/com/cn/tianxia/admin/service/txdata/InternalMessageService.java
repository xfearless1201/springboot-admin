package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.InternalMessage;

public interface InternalMessageService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(InternalMessage record);

    InternalMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InternalMessage record);

}
