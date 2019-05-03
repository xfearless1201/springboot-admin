package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.CagentVoice;

public interface CagentVoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentVoice record);

    int insertSelective(CagentVoice record);

    CagentVoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentVoice record);

    int updateByPrimaryKey(CagentVoice record);
}