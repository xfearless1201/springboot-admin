package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserLogin;

public interface UserLoginService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLogin record);
}
