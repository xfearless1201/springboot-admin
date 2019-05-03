package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Voice;

public interface VoiceService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Voice record);

    Voice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Voice record);
}
