package com.cn.tianxia.admin.web.activity;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserAcitivityRecord;
import com.cn.tianxia.admin.service.txdata.UserAcitivityRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zed
 * @Date: 2019/4/27 16:36
 * @Description: 刮奖记录
 */
@RestController
@RequestMapping("/activity/guagua")
@Slf4j
public class GuaPrizeRecordController {
    @Autowired
    private UserAcitivityRecordService userAcitivityRecordService;

    @RequestMapping("/record")
    public ResultResponse guaRecordList(@RequestParam Map<String, String> params) {
        Pager<UserAcitivityRecord> pager = userAcitivityRecordService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
}
