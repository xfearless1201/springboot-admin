package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.CagentLuckyDraw;
import com.cn.tianxia.admin.service.txdata.CagentLuckyDrawService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:26
 * @Description: 红包活动配置controller
 */
@RestController
@RequestMapping("/activity/redpacket")
@Slf4j
public class RedPacketConfigurationController {

    @Autowired
    private CagentLuckyDrawService cagentLuckyDrawService;

    @RequestMapping("/list")
    public ResultResponse configList(@RequestParam Map<String,String> params) {
        Pager<CagentLuckyDraw> pager = cagentLuckyDrawService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
