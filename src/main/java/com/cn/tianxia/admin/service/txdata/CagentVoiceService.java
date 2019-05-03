package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.CagentVoice;

public interface CagentVoiceService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CagentVoice record);

    CagentVoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentVoice record);

}
