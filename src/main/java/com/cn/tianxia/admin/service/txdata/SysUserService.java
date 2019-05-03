package com.cn.tianxia.admin.service.txdata;

import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.SysUser;

public interface SysUserService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);
    
    /**
     * 
     * @Description 通过用户登录账号查询用户信息
     * @param loginName
     * @return
     */
    SysUser selectByLoginName(String loginName)throws RRException;
    
    Pager<SysUser> list(Map<String,String> params);
    
    int save(SysUser user)throws Exception;
    
    SysUser info(Long id) throws Exception;
    
}
