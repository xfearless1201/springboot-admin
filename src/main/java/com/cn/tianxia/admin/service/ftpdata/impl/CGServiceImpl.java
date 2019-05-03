package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.CgRecordMapper;
import com.cn.tianxia.admin.project.ftpdata.CgRecord;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.CGService;

@Service
public class CGServiceImpl implements CGService {

    Logger logger = LoggerFactory.getLogger(CGServiceImpl.class);
    
    @Autowired
    private CgRecordMapper cgRecordMapper;
    
    @SuppressWarnings("unchecked")
    @Override
    public Pager<CgRecord> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class,data);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    @SuppressWarnings("hiding")
    @Override
    public <CgRecord> Pager<CgRecord> list(Pager<CgRecord> pager) {
        List<CgRecord> pager1 = cgRecordMapper.findAllByPage(pager);
        Pager<CgRecord> pager2 = new Pager<>();
        pager2.setList(pager1);
        return pager2;
    }

}
