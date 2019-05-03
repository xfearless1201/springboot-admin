package com.cn.tianxia.admin.web.sys;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.tianxia.admin.base.shiro.ShiroUser;

/**
 * 
 * @ClassName BaseController
 * @Description 父类公共组建给子类继承
 * @author Hardy
 * @Date 2019年4月17日 下午9:01:54
 * @version 1.0.0
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    protected ShiroUser getUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getId();//用户ID
    }

    protected String getUsername() {
        return getUser().getLoginName();//获取登录账号
    }
    
    //平台ID
    protected Integer getCid() {
        return getUser().getCid();
    }
    
    //用户类型  0 （管理员,平台商） 1 （一级代理） 2（二级代理）
    protected Integer getType() {
    	return getUser().getType();
    }
    
    public boolean isAdmin(){
    	return getUser().getUserType()==0;
    }
    
}
