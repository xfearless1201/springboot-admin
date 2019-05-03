package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.CgRecord;

public interface CgRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CgRecord record);

    int insertSelective(CgRecord record);

    CgRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CgRecord record);

    int updateByPrimaryKey(CgRecord record);

    @SuppressWarnings("hiding")
    <CgRecord> List<CgRecord> findAllByPage(Pager<CgRecord> pager);
}