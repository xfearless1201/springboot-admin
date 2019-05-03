package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.UserDissociate;

public interface UserDissociateMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserDissociate record);

    int insertSelective(UserDissociate record);

    UserDissociate selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserDissociate record);

    int updateByPrimaryKey(UserDissociate record);
}