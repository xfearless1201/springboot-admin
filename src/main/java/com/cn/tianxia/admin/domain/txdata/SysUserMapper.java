package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByLoginName(String loginName);
    
    List<SysUser> findAllByPage(Pager<SysUser> pager);
    
    int getRoleTotalCounts(Pager<SysUser> pager);
    
    SysUser selectByPhone(String phone);
}