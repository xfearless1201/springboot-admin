package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserWalletLog;

public interface UserWalletLogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserWalletLog record);

    UserWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWalletLog record);
}
