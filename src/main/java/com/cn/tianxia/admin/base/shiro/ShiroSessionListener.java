package com.cn.tianxia.admin.base.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 
 * @ClassName ShiroSessionListener
 * @Description 自定义shirosession监听器
 * @author Hardy
 * @Date 2019年4月18日 下午5:39:52
 * @version 1.0.0
 */
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);
    
    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }

}
