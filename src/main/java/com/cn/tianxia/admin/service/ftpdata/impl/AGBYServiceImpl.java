package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.AgHsrMapper;
import com.cn.tianxia.admin.project.ftpdata.AgHsr;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.AGBYService;

@Service
public class AGBYServiceImpl implements AGBYService {

    @Autowired
    private AgHsrMapper agHsrMapper;
    
    Logger logger = LoggerFactory.getLogger(AGBYServiceImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public Pager<AgHsr> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class,data);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    @SuppressWarnings("hiding")
    @Override
    public <AgHsr> Pager<AgHsr> list(Pager<AgHsr> pager) {
        List<AgHsr> pager1 = agHsrMapper.findAllByPage(pager);
        Pager<AgHsr> pager2 = new Pager<>();
        pager2.setList(pager1);
        return pager2;
    }

}
