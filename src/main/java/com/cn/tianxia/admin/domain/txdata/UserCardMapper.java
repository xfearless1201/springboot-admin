package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserCard;

public interface UserCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCard record);

    int insertSelective(UserCard record);

    UserCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCard record);

    int updateByPrimaryKey(UserCard record);
}