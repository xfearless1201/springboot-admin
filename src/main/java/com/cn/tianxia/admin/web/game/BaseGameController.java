package com.cn.tianxia.admin.web.game;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.shiro.ShiroUser;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.enums.GameServiceEnum;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.BaseQueryService;

/**
 * @ClassName BaseGameController
 * @Description TODO(查询游戏注单入口类)
 * @author Hardy
 * @Date 2019年4月27日 下午10:08:14
 * @version 1.0.0
 */
@RestController
@RequestMapping("/game")
public class BaseGameController {
	
	Logger logger = LoggerFactory.getLogger(BaseGameController.class);
	
	protected ShiroUser getUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

	protected Long getUserId() {
	    return getUser().getId();//用户ID
	}

	/**
	 * 表单查询入口
	 * @param contiton
	 * @return
	 */
	@RequestMapping("/list")
	public ResultResponse queryGameRecord(@RequestBody FormData data){
	    try {
	        String gameType = data.getGameType();
	        //通过游戏类型获取对应的服务
	        BaseQueryService queryService = GameServiceEnum.valueOf(gameType).getQueryService();
	        //将查询参数FormData统一转换成Pager
	        Pager<?> pager = queryService.transFormDataToPager(data);
	        Pager<?> resultPager = queryService.list(pager);
	        return ResultResponse.success("successed", resultPager);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return ResultResponse.error(e.getMessage());
        }
	}
	
	public static void main(String[] args) {
	    FormData contiton = new FormData();
	    contiton.setGameType("AGIN");
        new BaseGameController().queryGameRecord(contiton);
    }
}
