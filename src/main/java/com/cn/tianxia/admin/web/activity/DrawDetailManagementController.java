package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.LotteryRecord;
import com.cn.tianxia.admin.service.txdata.LotteryRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:40
 * @Description: 抽奖明细管理controller
 */
@RestController
@RequestMapping("/activity/detail")
@Slf4j
public class DrawDetailManagementController {
    @Autowired
    private LotteryRecordService lotteryRecordService;

    @RequestMapping("/list")
    public ResultResponse lotteryRecord(@RequestParam Map<String, String> params) {
        Pager<LotteryRecord> pager = lotteryRecordService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
