package com.cn.tianxia.admin.vo.txdata;

import net.sf.oval.constraint.NotEmpty;

/**
 * @ClassName LoginVO
 * @Description 登录VO类
 * @author Hardy
 * @Date 2019年4月27日 下午3:21:55
 * @version 1.0.0
 */
public class LoginVO{

    @NotEmpty(message="用户名不能为空")
    private String username;

    @NotEmpty(message="登录密码不能为空")
    private String password;

    @NotEmpty(message="验证码不能为空")
    private String captcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
