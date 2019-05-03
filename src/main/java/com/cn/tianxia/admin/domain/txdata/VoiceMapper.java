package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.Voice;

public interface VoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Voice record);

    int insertSelective(Voice record);

    Voice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Voice record);

    int updateByPrimaryKey(Voice record);
}