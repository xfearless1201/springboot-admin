package com.cn.tianxia.admin.service.txdata.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.service.txdata.SessionService;


/**
 * 
 * @ClassName SessionServiceImpl
 * @Description session实现类
 * @author Hardy
 * @Date 2019年4月18日 下午5:47:45
 * @version 1.0.0
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDAO sessionDAO;
    
    @Override
    public boolean forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        return true;
    }

    @Override
    public List<ShiroUser> list() {
        List<ShiroUser> list = new ArrayList<>();
        return list;
    }

}
