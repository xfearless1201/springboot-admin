package com.cn.tianxia.admin.web.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.service.txdata.RoleService;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * 
 * @ClassName SysRoleController
 * @Description 系统角色接口
 * @author Hardy
 * @Date 2019年4月25日 下午8:44:33
 * @version 1.0.0
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController{

    @Autowired
    private RoleService  roleService;
    
    @Autowired
    private Validator validator;
    
    /**
     * 
     * @Description 角色列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public ResultResponse list(@RequestParam Map<String,String> params){
        //如果是超级会员则可以
        if(!getUsername().equals(Constant.SUPER_ACCOUNT)){
            //根据平台ID只能查看自己平台下面的
            params.put("cid", getCid().toString());
        }
        Pager<Role> pager = roleService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    
    
    @RequestMapping("/add")
    @RequiresPermissions("sys:role:add")
    public ResultResponse add(@RequestBody Role role){
        try {
            //校验请求参数
            List<ConstraintViolation> valid = validator.validate(role);
            if(!CollectionUtils.isEmpty(valid)){
                return ResultResponse.error(valid.get(0).getMessage());
            }
            //保存用户角色信息
            roleService.save(role);
            return ResultResponse.success();
        }catch(RRException e){
            return ResultResponse.error(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("新增角色信息异常:{}",e.getMessage());
            return ResultResponse.error("新增角色信息异常,请联系客服");
        }
        
    }
    
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResultResponse update(@RequestBody Role role){
        return ResultResponse.success();
    }
    
    @RequestMapping("/delete/{id}")
    @RequiresPermissions("sys:role:delete")
    public ResultResponse delete(@PathVariable("id") long id){
        return null;
    }
    
    
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:role:info")
    public ResultResponse info(@PathVariable("id") long id){
        Role role = roleService.info(id);
        return ResultResponse.success("查询成功", role);
    }
   
    
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public List<Role> select(){
        List<Role> roles = new ArrayList<>();
        //判断是否为超级管理员
        Pager<Role> pager = new Pager<>();
        pager.setPage(null);
        pager.setLimit(null);
        Map<String,String> params = new HashMap<>();
        params.put("status", "0");
        if(!getUsername().equals(Constant.SUPER_ACCOUNT)){
            //超级管理员,查看所有的平台
            params.put("cid", getCid().toString());
        }
        pager.setParams(params);
        roles = roleService.getRoleSelectList(pager);
        return roles;
    }
}
