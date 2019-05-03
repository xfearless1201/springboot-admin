package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.Organization;

public interface OrganizationService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

}
