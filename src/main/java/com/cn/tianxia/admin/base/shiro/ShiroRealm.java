package com.cn.tianxia.admin.base.shiro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.txdata.ShiroUserService;


/**
 * 
 * @ClassName ShiroRealm
 * @Description realm配置类
 * @author Hardy
 * @Date 2019年4月17日 上午10:05:58
 * @version 1.0.0
 */
@Component
public class ShiroRealm extends AuthorizingRealm{

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    
    @Autowired
    private ShiroUserService shiroUserService;
    
    
    /**
     * 授权(用户登录成功后获取用户具备的权限)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取登录认证时传给shiro的用户信息
        ShiroUser user = (ShiroUser) principals.getPrimaryPrincipal();
        //用户权限列表
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(user.getUrls());
        info.setRoles(user.getRoles());
        return info;
    }
    
    /**
     * 认证(用户登录时验证用户密码)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        try {
            UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
            String username = token.getUsername();
            //查询用户信息
            SysUser user = shiroUserService.selectByLoginName(username);
            //账号不存在
            if(user == null) {
                throw new UnknownAccountException("账号或密码不正确");
            }
            //判断用户状态
            if(user.getStatus() == 1){
                throw new DisabledAccountException("账号被禁用");
            }
            Set<String> urls = new HashSet<String>();
            Set<String> roles = new HashSet<>();
            //获取用户角色信息
            Role role = shiroUserService.selectByUserId(user.getId());
            roles.add(role.getId().toString());//角色ID
            //获取用户具备的资源url和角色信息
            List<Resource> resources = shiroUserService.getResourcesByUserId(user.getId());
            resources.stream().forEach(item->{
                if(StringUtils.isNotBlank(item.getPerms())){
                    List<String> perms = Arrays.asList(item.getPerms().split(","));
                    urls.addAll(perms);
                }
            });
            ShiroUser shiroUser = new ShiroUser(user.getId(),user.getCid(),user.getType(),username,user.getName(),role.getName(),urls,roles, user.getUserType());
            shiroUser.setRoleName(role.getName());
            SimpleAuthenticationInfo info = 
                    new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getSalt()), getName());
            return info;
        } catch (AccountException e) {
            e.printStackTrace();
            logger.info("账号异常:{}"+e.getMessage());
            throw new AccountException("账号异常,请联系客服!");
        }
    }

    /**
     *  重写校验规则
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashMD5AlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashMD5Iterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
    
}
