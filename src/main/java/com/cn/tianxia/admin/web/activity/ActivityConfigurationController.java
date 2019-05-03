package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.ActivityDetails;
import com.cn.tianxia.admin.service.txdata.ActivityDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:32
 * @Description: 活动配置controller
 */
@RestController
@RequestMapping("/activity/config")
@Slf4j
public class ActivityConfigurationController {
    @Autowired
    private ActivityDetailsService activityDetailsService;

    @RequestMapping("/list")
    public ResultResponse activityList(@RequestParam Map<String,String> params) {
        Pager<ActivityDetails> pager = activityDetailsService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
