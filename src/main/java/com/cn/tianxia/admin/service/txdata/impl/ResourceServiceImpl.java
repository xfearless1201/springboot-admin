package com.cn.tianxia.admin.service.txdata.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.domain.txdata.ResourceMapper;
import com.cn.tianxia.admin.domain.txdata.RoleMapper;
import com.cn.tianxia.admin.domain.txdata.RoleResourceMapper;
import com.cn.tianxia.admin.exception.RRException;
import com.cn.tianxia.admin.project.txdata.Resource;
import com.cn.tianxia.admin.project.txdata.Role;
import com.cn.tianxia.admin.service.txdata.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Resource record) {
        record.setCreateTime(new Date());
        record.setStatus((byte)0);
        if(record.getType() == Constant.MenuType.MENU.getValue() || record.getType() == Constant.MenuType.BUTTON.getValue()){
            //如果是菜单或者按钮的时候,存入父级名称
            Resource resource = resourceMapper.selectByPrimaryKey(record.getPid());
            record.setPname(resource.getName());
        }
        return resourceMapper.insertSelective(record);
    }

    @Override
    public Resource selectByPrimaryKey(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Resource record) {
        
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Resource> getResourcesByUserId(Long userId) {
        logger.info("查询用户具备的资源信息开始==============START==================");
        
        Set<Resource> result = new HashSet<>();
        // 1.通过用户ID查询用户的角色ID
        Role role = roleMapper.selectRoleIdByUserId(userId);
        // 2.通过角色ID查询角色具备的所有权限资源ID
        List<Long> resourceIds = roleResourceMapper.findAllResourceIdsByRoleId(role.getId());
        //获取所有得我资源信息
        List<Resource> resources = resourceMapper.findAll();
        resourceIds.stream().forEach(resourceId->{
            Resource resource = resources.stream().filter(item-> item.getId().longValue() == resourceId.longValue()).findFirst().get();
            result.add(resource);
        });
        return resources;
    }

    @Override
    public List<Resource> getSubResourcesByPid(Long pid) {
        return resourceMapper.findAllByPid(pid);
    }

    
    /**
     * 保存
     */
    @Override
    public int save(Resource record) throws RRException{
        if(record.getId() == null){
            //新增
            record.setCreateTime(new Date());
            //插入菜单信息
            return resourceMapper.insertSelective(record);
        }else {
            //修改,通过菜单ID查询菜单信息
            Resource resource = resourceMapper.selectByPrimaryKey(record.getId());
            if(resource == null){
                logger.info("修改菜单信息失败,菜单ID:{},查询无菜单信息",record.getId());
                throw new RRException("修改菜单信息失败");
            }
            resource.setName(record.getName());//菜单名称
            resource.setIcon(record.getIcon());//菜单图标
            resource.setIsSys(record.getIsSys());//是否为系统资源
            resource.setNicon(record.getNicon());//新图标
            resource.setNurl(record.getNurl());//新URL地址
            resource.setPerms(record.getPerms());//授权标识
            resource.setPid(record.getPid());//父级ID
            resource.setPname(record.getPname());//父级名称
            resource.setSeq(record.getSeq());//排序
            resource.setStatus(record.getStatus());//菜单状态
            resource.setType(record.getType());//菜单类型
            resource.setUrl(record.getUrl());//菜单旧URL地址
            //修改菜单信息
            return resourceMapper.updateByPrimaryKeySelective(resource);
        }
    }

    /**
     * 获取所有的资源信息
     */
    @Override
    public List<Resource> findAllResources() {
        //查询所有的资源信息
        List<Resource> resources = resourceMapper.findAll();
        return resources;
    }

    
    /**
     * 禁用或启用资源
     */
    @Override
    public int disableOrEnable(Resource record) throws RRException {
        //通过资源ID查询资源信息
        Resource resource = resourceMapper.selectByPrimaryKey(record.getId());
        if(resource.getStatus() == record.getStatus()){
            return 1;
        }else{
            resource.setStatus(record.getStatus());
            //修改
            return resourceMapper.updateByPrimaryKeySelective(resource);
        }
    }
}
