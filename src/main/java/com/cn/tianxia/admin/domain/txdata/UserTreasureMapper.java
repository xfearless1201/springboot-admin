package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserTreasure;

public interface UserTreasureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTreasure record);

    int insertSelective(UserTreasure record);

    UserTreasure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTreasure record);

    int updateByPrimaryKey(UserTreasure record);
}