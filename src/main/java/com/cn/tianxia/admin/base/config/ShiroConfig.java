package com.cn.tianxia.admin.base.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cn.tianxia.admin.base.shiro.ShiroRealm;
import com.cn.tianxia.admin.base.shiro.ShiroSessionListener;

/**
 * 
 * @ClassName ShiroConfig
 * @Description shiro配置类
 * @author Hardy
 * @Date 2019年4月16日 下午10:47:39
 * @version 1.0.0
 */
@Configuration
public class ShiroConfig {
    
    
    @Bean
    public SessionDAO sessionDAO(){
        MemorySessionDAO sessionDAO = new MemorySessionDAO();
        return sessionDAO;
    }
    
    @Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("shiro.session");
        simpleCookie.setPath("/");
        return simpleCookie;
    }
    
    /**
     * 
     * @Description session交给shiro管理
     * @return
     */
    @Bean
    public SessionManager sessionManager(@Qualifier("sessionDAO") SessionDAO sessionDAO,
                                            @Qualifier("simpleCookie") SimpleCookie simpleCookie){
        DefaultWebSessionManager  sessionManager = new DefaultWebSessionManager ();
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new ShiroSessionListener());
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setSessionIdCookie(simpleCookie);
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
    
    /**
     * 
     * @Description 权限
     * @param shiroRealm
     * @return
     */
    @Bean
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm,
                                            @Qualifier("sessionManager") SessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    
    
    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //登录的url
        shiroFilter.setLoginUrl("/login.html");
        //登录成功跳转页面
        shiroFilter.setSuccessUrl("/index.html");
        //未授权url
        shiroFilter.setUnauthorizedUrl("/");
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        
        
        filterMap.put("/statics/**", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/actuator/**", "anon");
        filterMap.put("/online/**", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/captcha.jpg", "anon");
        //配置退出过滤器
        filterMap.put("/logout", "logout");
        //除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }
    
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
