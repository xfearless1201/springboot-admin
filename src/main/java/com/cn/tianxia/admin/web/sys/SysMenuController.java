package com.cn.tianxia.admin.web.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.annotation.SysLog;
import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.service.txdata.ResourceService;

/**
 * 
 * @ClassName SysMenuController
 * @Description 系统菜单接口
 * @author Hardy
 * @Date 2019年4月24日 下午6:52:51
 * @version 1.0.0
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private ResourceService resourceService;
    
    @RequestMapping("/nav")
    public ResultResponse nav(){
        List<Resource> resources = new ArrayList<>();
        //判断是否为超级管理员
        if(getUsername().equals(Constant.SUPER_ACCOUNT)){
            resources = resourceService.findAllResources();
        }else{
            resources = resourceService.getResourcesByUserId(getUserId());
        }
        // 获取目录信息
        List<Resource> catalogs = resources.stream().filter(r -> r.getType() == Constant.MenuType.CATALOG.getValue())
                .collect(Collectors.toList());
        
        //目录排序
        catalogs.sort((s1,s2) -> s1.getId().intValue() - s2.getId().intValue());
        // 获取菜单信息
        List<Resource> menus = resources.stream().filter(r -> r.getType() == Constant.MenuType.MENU.getValue())
                .collect(Collectors.toList());
        // 菜单分组
        Map<Long, List<Resource>> menumap = menus.stream().collect(Collectors.groupingBy(r -> r.getPid()));
        // 组装菜单树
        catalogs.stream().forEach(r -> {
            List<Resource> submenus = menumap.get(r.getId());
            //排序
            if(!CollectionUtils.isEmpty(submenus)){
                submenus.sort((s1,s2) -> s1.getSeq() - s2.getSeq());
                r.setList(submenus);
            }
            r.setOpen(true);
        });
        return ResultResponse.success("查询成功", catalogs);
    }
    
    
    /**
     * 
     * @Description 获取资源列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<Resource> list(){
        if(getUsername().equals(Constant.SUPER_ACCOUNT)){
            //如果是超级管理员,测查看所有的资源
            return resourceService.findAllResources();
        }else{
            return resourceService.getResourcesByUserId(getUserId());
        }
    }
    
    /**
     * 选择菜单(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public ResultResponse select(){
        List<Resource> resources = new ArrayList<>();
        //判断是否为超级管理员
        if(getUsername().equals(Constant.SUPER_ACCOUNT)){
            //查看所有权限
            resources = resourceService.findAllResources();
        }else{
            //查看自己具备的资源
            resources = resourceService.getResourcesByUserId(getUserId());
        }
        if(!CollectionUtils.isEmpty(resources)){
            resources = 
                    resources.stream().filter(item-> item.getType() != Constant.MenuType.BUTTON.getValue()).collect(Collectors.toList());
            //添加顶级菜单
            Resource root = new Resource();
            root.setId(0L);
            root.setName("一级菜单");
            root.setPid(-1L);
            root.setOpen(true);
            resources.add(root);
        }
        return ResultResponse.success("查询成功", resources);
    }
    
    
    /**
     * 
     * @Description 获取菜单信息
     * @param menuId
     * @return
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public ResultResponse info(@PathVariable("menuId") Long menuId){
        Resource resource = resourceService.selectByPrimaryKey(menuId);
        return ResultResponse.success("查询成功", resource);
    }
    
    /**
     * 
     * @Description 修改菜单
     * @param resource
     * @return
     */
    @SysLog("修改菜单")
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public ResultResponse update(@RequestBody Resource resource){
        try {
          //校验数据
            verifyForm(resource);
            //更新资源
            resourceService.save(resource);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("更新菜单信息异常:{}",e.getMessage());
            return ResultResponse.error("更新菜单信息异常:"+e.getMessage());
        }
        
    }
    
    /**
     * 
     * @Description 新增
     * @param resource
     * @return
     */
    @SysLog("保存菜单")
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public ResultResponse save(@RequestBody Resource resource){
        try {
          //数据校验
            verifyForm(resource);
            //存入数据
            resourceService.insertSelective(resource);
            return ResultResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("新增菜单信息异常:{}",e.getMessage());
            return ResultResponse.error("新增菜单信息异常:"+e.getMessage());
        }
        
    }
    
    
    /**
     * 
     * @Description 删除数据
     * @param menuId
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public ResultResponse delete(long menuId){
        //通过菜单ID查询菜单信息
        Resource resource = resourceService.selectByPrimaryKey(menuId);
        if(resource != null){
            if(resource.getIsSys() == Constant.SYS_RESOURCE){
                return ResultResponse.error("系统菜单，不能删除");
            }
        }
        //判断是否存在子菜单
        List<Resource> subResources = resourceService.getSubResourcesByPid(resource.getId());
        if(!CollectionUtils.isEmpty(subResources)){
            return ResultResponse.error("请先删除子菜单或按钮");
        }
        resourceService.deleteByPrimaryKey(menuId);
        return ResultResponse.success();
    }
    
    
    /**
     * 
     * @Description 禁用或开启菜单
     * @return
     */
    @RequestMapping("/disable")
    @RequiresPermissions("sys:menu:disable")
    public ResultResponse disableOrEnable(@RequestBody Resource record){
        resourceService.disableOrEnable(record);
        return ResultResponse.success();
    }
    
    
    /**
     * 验证参数是否正确
     */
    private void verifyForm(Resource resource){
        if(StringUtils.isBlank(resource.getName())){
            throw new RRException("菜单名称不能为空");
        }
        
        if(resource.getPid() == null){
            throw new RRException("上级菜单不能为空");
        }
        
        //菜单
        if(resource.getType() == Constant.MenuType.MENU.getValue()){
            if(StringUtils.isBlank(resource.getNurl())){
                throw new RRException("菜单URL不能为空");
            }
        }
        
        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if(resource.getPid() != 0){
            Resource parentMenu = resourceService.selectByPrimaryKey(resource.getPid());
            parentType = parentMenu.getType();
        }
        
        //目录、菜单
        if(resource.getType() == Constant.MenuType.CATALOG.getValue() ||
                resource.getType() == Constant.MenuType.MENU.getValue()){
            if(parentType != Constant.MenuType.CATALOG.getValue()){
                throw new RRException("上级菜单只能为目录类型");
            }
            return ;
        }
        
        //按钮
        if(resource.getType() == Constant.MenuType.BUTTON.getValue()){
            if(parentType != Constant.MenuType.MENU.getValue()){
                throw new RRException("上级菜单只能为菜单类型");
            }
            return ;
        }
    }
}
