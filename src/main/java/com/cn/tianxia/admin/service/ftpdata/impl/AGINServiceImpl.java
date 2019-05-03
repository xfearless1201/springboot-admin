package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.AgBrMapper;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.AGINService;
import com.cn.tianxia.admin.project.ftpdata.AgBr;
/**
 * 
 * @ClassName AGINServiceImpl
 * @Description TODO(AG视讯查询服务)
 * @author Hardy
 * @Date 2019年4月28日 下午4:16:59
 * @version 1.0.0
 */
@Service
public class AGINServiceImpl implements AGINService{

    private Logger logger = LoggerFactory.getLogger(AGINServiceImpl.class);
    
    @Autowired
    private AgBrMapper agbrMapper;

    @SuppressWarnings("unchecked")
    @Override
    public Pager<AgBr> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class,data);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    @SuppressWarnings("hiding")
    @Override
    public <AgBr> Pager<AgBr> list(Pager<AgBr> pager) {
        List<AgBr> pager1 = agbrMapper.findAllByPage(pager);
        Pager<AgBr> pager2 = new Pager<>();
        pager2.setList(pager1);
        return pager2;
    }
}
