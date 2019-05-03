package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.BbinRecordMapper;
import com.cn.tianxia.admin.project.ftpdata.BbinRecord;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.BBINService;

@Service
public class BBINServiceImpl implements BBINService{

    private Logger logger = LoggerFactory.getLogger(BBINServiceImpl.class);
    
    @Autowired
    private BbinRecordMapper bbinRecordMapper;
    @SuppressWarnings("unchecked")
    @Override
    public Pager<BbinRecord> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class,data);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    @SuppressWarnings("hiding")
    @Override
    public <BbinRecord> Pager<BbinRecord> list(Pager<BbinRecord> pager) {
        List<BbinRecord> pager1 = bbinRecordMapper.findAllByPage(pager);
        Pager<BbinRecord> pager2 = new Pager<>();
        pager2.setList(pager1);
        return pager2;
    }

}
