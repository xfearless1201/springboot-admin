package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.LotteryRecord;

import java.util.List;

public interface LotteryRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LotteryRecord record);

    int insertSelective(LotteryRecord record);

    LotteryRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryRecord record);

    int updateByPrimaryKey(LotteryRecord record);

    List<LotteryRecord> selectAllByPage(Pager pager);

    int selectTotalCount(Pager pager);
}