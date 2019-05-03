package com.cn.tianxia.admin.service.ftpdata;

import com.cn.tianxia.admin.project.ftpdata.CqjRecord;

public interface CqjRecordService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CqjRecord record);

    CqjRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CqjRecord record);
}
