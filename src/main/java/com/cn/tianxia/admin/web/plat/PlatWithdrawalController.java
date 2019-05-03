package com.cn.tianxia.admin.web.plat;

import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;
import com.cn.tianxia.admin.service.txdata.PlatWithdrawalService;
import com.cn.tianxia.admin.web.sys.BaseController;

@RestController
@RequestMapping("/plat/withdrawal")
public class PlatWithdrawalController extends BaseController{

    @Autowired
    private PlatWithdrawalService platWithdrawalService;
    
    /**
     * 
     * @Description 查看存取款配置列表信息
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("plat:withdrawal:list")
    public ResultResponse list(@RequestParam Map<String,String> params) {
        Pager<PlatWithdrawal> pager = platWithdrawalService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条存取款配置信息
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("plat:withdrawal:info")
    public ResultResponse info(@PathVariable("id") Integer id) {
        PlatWithdrawal platWithdrawal = platWithdrawalService.info(id);
        return ResultResponse.success("查询成功", platWithdrawal);
    }
    /**
     * 
     * @Description 修改单条存取款配置信息
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("plat:withdrawal:update")
    public ResultResponse update(@RequestBody PlatWithdrawal platWithdrawal) {
        platWithdrawal.setUpdatetime(new Date());
        platWithdrawal.setUid(getUserId());
        int result = platWithdrawalService.update(platWithdrawal);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
}
