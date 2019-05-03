package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.vo.txdata.UserMemberVO;

public interface UserMemberMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserMember record);

    int insertSelective(UserMember record);

    UserMember selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserMember record);

    int updateByPrimaryKey(UserMember record);

	List<UserMember> memberInquiry(Pager<UserMemberVO> pager);

	int memberInquiryCount(Pager<UserMemberVO> pager);
}