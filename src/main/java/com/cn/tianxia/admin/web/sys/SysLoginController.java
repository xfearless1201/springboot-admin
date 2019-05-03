package com.cn.tianxia.admin.web.sys;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.shiro.ShiroUtils;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.vo.txdata.LoginVO;
import com.google.code.kaptcha.Constants;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName LoginController
 * @Description 系统登录接口
 * @author Hardy
 * @Date 2019年4月17日 上午9:57:12
 * @version 1.0.0
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends BaseController{
    
    @Autowired
    private Validator validator;
    
    /**
     * 
     * @Description 登录接口
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @PostMapping("/login")
    public ResultResponse login(LoginVO loginVO){
        //校验请求参数
        List<ConstraintViolation> valid = validator.validate(loginVO);
        if(!CollectionUtils.isEmpty(valid)){
            logger.info("登录请求参数异常:{}",valid.get(0).getMessage());
            return ResultResponse.faild(valid.get(0).getMessage());
        }
        //获取用户缓存的验证码信息
        try{
            String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
            if(!loginVO.getCaptcha().equalsIgnoreCase(kaptcha)){
                return ResultResponse.faild("验证码输入不正确!");
            }
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(),loginVO.getPassword());
            subject.login(token);
        }catch (UnknownAccountException e) {
            return ResultResponse.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return ResultResponse.error("账号或密码不正确");
        }catch (LockedAccountException e) {
            return ResultResponse.error("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
            return ResultResponse.error("账户验证失败");
        }catch (RRException e){
            return ResultResponse.error(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("用户:{}调用登录接口异常!!!",loginVO.getUsername());
            return ResultResponse.error("登录异常,请联系客服");
        }
        return ResultResponse.success();
    }
}
