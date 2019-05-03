package com.cn.tianxia.admin.web.cagent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.service.txdata.CagentService;
import com.cn.tianxia.admin.web.sys.BaseController;

/**
 * 
 * @ClassName CagentController
 * @Description 平台商接口
 * @author Hardy
 * @Date 2019年4月28日 上午11:08:33
 * @version 1.0.0
 */
@RestController
@RequestMapping("/cagent")
public class CagentController extends BaseController{
    
    @Autowired
    private CagentService cagentService;

    /**
     * 
     * @Description 查看平台商列表信息
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("cagent:list")
    public ResultResponse list(@RequestParam Map<String,String> params){
        Pager<Cagent> pager = cagentService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    
    /**
     * 
     * @Description 平台选择树
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("cagent:select")
    public List<Cagent> select(){
        List<Cagent> cagents = new ArrayList<>();
        //判断是否为超级管理员
        if(getUsername().equals(Constant.SUPER_ACCOUNT)){
            //超级管理员,查看所有的平台
            Pager<Cagent> pager = new Pager<>();
            pager.setPage(null);
            pager.setLimit(null);
            Map<String,String> params = new HashMap<>();
            params.put("status", "0");
            pager.setParams(params);
            cagents = cagentService.getCagentSelectList(pager);
            //默认的天下平台
            Cagent cagent = new Cagent();
            cagent.setId(0);
            cagent.setName("平台中心");
            cagent.setCagent("TXPT");
            cagents.add(cagent);
        }else{
            //用户
            Cagent c = cagentService.selectByPrimaryKey(getCid());
            cagents.add(c);
        }
        return cagents;
    }
}
