package com.cn.tianxia.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.tianxia.admin.domain.ftpdata.CqjRecordMapper;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.project.ftpdata.CqjRecord;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.ftpdata.CqjRecordService;
import com.cn.tianxia.admin.service.txdata.SysUserService;
import com.cn.tianxia.admin.utils.RedisUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Bootstrap.class)
public class BootstrapTest {
    
    private static final Logger logger = LoggerFactory.getLogger(BootstrapTest.class);
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private CqjRecordMapper cqjRecordMapper;
    
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private CqjRecordService cqjRecordService;
    
    
    @Autowired
    private RedisUtils redisUtils;
    
//    @Test
    public void testMapper(){
        logger.info("测试txdata数据源的链接情况=============START===================");
        //查询用户信息
        SysUser user = sysUserMapper.selectByLoginName("admin");
        logger.info("测试txdata数据源的结果为:{}",user.getLoginName());
        
        logger.info("开始查询从库数据");
        CqjRecord reccord = cqjRecordMapper.selectByPrimaryKey(100);
        System.err.println(reccord.toString());
    }
    
//    @Test
    public void testService(){
        logger.info("测试txdata数据源的链接情况=============START===================");
        //查询用户信息
        SysUser user = sysUserService.selectByPrimaryKey(1L);
        logger.info("测试txdata数据源的结果为:{}",user.getLoginName());
        
        logger.info("开始查询从库数据");
        CqjRecord reccord = cqjRecordService.selectByPrimaryKey(100);
        System.err.println(reccord.toString());
    }
    
    @Test
    public void testRedis(){
        String name = "hardy";
        String key = "hardy-tx";
        redisUtils.set(key, name);;
        
        String value = redisUtils.get(key);
        
        System.err.println(value);
    }
}
