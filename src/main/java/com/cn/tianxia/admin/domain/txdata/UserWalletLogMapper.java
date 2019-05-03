package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserWalletLog;

public interface UserWalletLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWalletLog record);

    int insertSelective(UserWalletLog record);

    UserWalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWalletLog record);

    int updateByPrimaryKey(UserWalletLog record);
}