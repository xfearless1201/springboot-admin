package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.DicData;

public interface DicDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DicData record);

    int insertSelective(DicData record);

    DicData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DicData record);

    int updateByPrimaryKey(DicData record);
}