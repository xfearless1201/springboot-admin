package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserLuckrdrawLog;
import com.cn.tianxia.admin.service.txdata.UserLuckrdrawLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:28
 * @Description: 红包抽奖记录controller
 */
@RestController
@RequestMapping("/activity/redpacket")
@Slf4j
public class RedPacketDrawRecordController {

    @Autowired
    UserLuckrdrawLogService userLuckrdrawLogService;

    @RequestMapping("/record")
//    @RequiresPermissions("activity:redpacket:record")
    public ResultResponse drawRecord(@RequestParam Map<String,String> params) {
        Pager<UserLuckrdrawLog> pager = userLuckrdrawLogService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
