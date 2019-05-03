package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.AgBr;
import com.cn.tianxia.admin.project.ftpdata.FormData;

public interface AgBrMapper{
    /**
     * 
     * @Description (根据主键删除数据)
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * @Description (插入ag视讯数据)
     * @param record
     * @return
     */
    int insert(AgBr record);

    /**
     * 
     * @Description (按照字段插入数据)
     * @param record
     * @return
     */
    int insertSelective(AgBr record);

    /**
     * 
     * @Description (根据id查询记录)
     * @param id
     * @return
     */
    AgBr selectByPrimaryKey(Integer id);

    /**
     * 
     * @Description (根据主键修改记录)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AgBr record);

    /**
     * 
     * @Description (修改记录)
     * @param record
     * @return
     */
    int updateByPrimaryKey(AgBr record);

    /**
     * 
     * @param <AgBr>
     * @Description (查询ag视讯注单)
     * @param pager
     */
    @SuppressWarnings("hiding")
    <AgBr> List<AgBr> findAllByPage(Pager<AgBr> pager);

    @SuppressWarnings("hiding")
    <AgBr> List<AgBr> platformDetailed(FormData platPage);

    Map<String, Object> countPlatformDetailed(FormData platPage);
}