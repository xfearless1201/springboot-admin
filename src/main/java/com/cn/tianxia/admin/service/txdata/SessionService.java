package com.cn.tianxia.admin.service.txdata;

import java.util.List;

import com.cn.tianxia.admin.base.shiro.ShiroUser;

/**
 * 
 * @ClassName SessionService
 * @Description session接口
 * @author Hardy
 * @Date 2019年4月18日 下午5:46:05
 * @version 1.0.0
 */
public interface SessionService {

    List<ShiroUser> list();
    
    boolean forceLogout(String sessionId);
}
