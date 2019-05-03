package com.cn.tianxia.admin.enums;

import com.cn.tianxia.admin.service.ftpdata.BaseQueryService;
import com.cn.tianxia.admin.utils.SpringContextUtils;

public enum GameServiceEnum {

    AGIN("AGIN","AGINServiceImpl"),
    AG("AG","AGINServiceImpl"),
    HUNTER("HUNTER","AGBYServiceImpl"),
    BBIN("BBIN","BBINServiceImpl"),
    CG("CG","CGServiceImpl"),
    ;
    
    private String gameType;
    private String mapper;
    
    GameServiceEnum(String gameType,String mapper){
      this.gameType = gameType;
      this.mapper = mapper;
  }
    
    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    public void setQueryService(String mapper) {
      this.mapper = mapper;
    }
    
    public BaseQueryService getQueryService() throws Exception {
        return (BaseQueryService) SpringContextUtils.getBean(this.mapper);
    }
}
