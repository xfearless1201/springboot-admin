package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.BbinRecord;

public interface BbinRecordMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(BbinRecord record);

    int insertSelective(BbinRecord record);

    BbinRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbinRecord record);

    int updateByPrimaryKey(BbinRecord record);

    @SuppressWarnings("hiding")
    <BbinRecord> List<BbinRecord> findAllByPage(Pager<BbinRecord> pager);
}