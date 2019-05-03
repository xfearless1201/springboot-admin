package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserMember;

public interface UserMemberService {

    int deleteByPrimaryKey(Integer uid);

    int insertSelective(UserMember record);

    UserMember selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserMember record);

	Pager<UserMember> MemberInquiry(Map<String, String> params)throws Exception;

}
