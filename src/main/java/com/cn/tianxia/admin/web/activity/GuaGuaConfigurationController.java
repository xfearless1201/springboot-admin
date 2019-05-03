package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.po.GGLActivityPO;
import com.cn.tianxia.admin.service.txdata.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:37
 * @Description: 刮刮乐活动配置controller
 */
@RestController
@RequestMapping("/activity/guagua")
@Slf4j
public class GuaGuaConfigurationController {

    @Autowired
    ActivityService activityService;

    @RequestMapping("/list")
    @RequiresPermissions(":activity:guagua:list")
    public ResultResponse signInRecord(@RequestParam Map<String,String> params) {
        Pager<GGLActivityPO> pager = activityService.gglList(params);
        return ResultResponse.success("查询成功", pager);
    }
}
