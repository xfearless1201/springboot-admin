package com.cn.tianxia.admin.web.sys;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.txdata.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName SysUserController
 * @Description 系统用户接口
 * @author Hardy
 * @Date 2019年4月24日 下午8:13:59
 * @version 1.0.0
 */
@Api(tags="系统用户接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController{
    
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private Validator validator;

    /**
     * 
     * @Description 获取用户信息
     * @return
     */
    @RequestMapping("/info")
    public ResultResponse info(){
        ShiroUser user = getUser();
        logger.info("查询用户:{},信息开始========START==============",user.getLoginName());
        return ResultResponse.success("获取成功",user);
    }
    
    
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params){
        Pager<SysUser> pager = sysUserService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    
    
    /**
     * 
     * @Description 新增用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    public ResultResponse add(@RequestBody SysUser user){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(user);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            sysUserService.save(user);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("保存用户信息异常:{}",e.getMessage());
            return ResultResponse.error("保存用户信息异常");
        }
    }
    
    /**
     * 
     * @Description 修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public ResultResponse update(@RequestBody SysUser user){
        try {
            //验证请求参数
            List<ConstraintViolation> valid = validator.validate(user);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.faild(valid.get(0).getMessage());
            }
            //参数校验成功,开始保存用户信息
            sysUserService.save(user);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("修改用户信息异常:{}",e.getMessage());
            return ResultResponse.error("修改用户信息异常");
        }
    }
    
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:user:info")
    public ResultResponse info(@PathVariable long id){
        try {
            SysUser user = sysUserService.info(id);
            return ResultResponse.success("查询成功", user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("根据用户ID:{"+id+"},查询用户信息异常:{}",e.getMessage());
            return ResultResponse.error("查询用户信息异常");
        }
        
    }
    
}
