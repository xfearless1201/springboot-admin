package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.UserType;

public interface UserTypeService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);
}
