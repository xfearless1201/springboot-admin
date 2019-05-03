package com.cn.tianxia.admin.service.ftpdata;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.FormData;

/**
 * @ClassName BaseQueryService
 * @Description TODO(通用查询接口，比如查询汇总)
 * @author Hardy
 * @Date 2019年4月28日 上午10:04:25
 * @version 1.0.0
 */
public interface BaseQueryService {

    /**
     * @param <T>
     * @param
     * @param data
     * @Description (将表单数据类型转换成统一的查询参数Pager)
     * @return
     */
    public Pager<?> transFormDataToPager(FormData data);

    /**
     * 
     * @param <T>
     * @Description (产生实例对象)
     * @return
     */
   @SuppressWarnings("unchecked")
   default <U,T> U newInstance(Class<U> class1,Object obj) throws Exception{
       if(null == class1){
           throw new IllegalArgumentException("clazz is null");
       }
       //obj为空则返回类型U
       U t = (U) Class.forName(class1.getName()).newInstance();
       if(null == obj){
           return t;
       } 
       //class类型不为空，且object不为空，则表示对象互转
       //如果是pager类型,obj是FormData
       if(class1.isAssignableFrom(Pager.class) && obj.getClass().isAssignableFrom(FormData.class)){
           Pager<T> pager = (Pager<T>) Class.forName(class1.getName()).newInstance();
           pager.setLimit(((FormData)obj).getRows());
           pager.setPage(((FormData)obj).getPage());
           HashMap<String, String> params = new HashMap<>(8);
           Field[] fields = obj.getClass().getDeclaredFields();
           Stream.of(fields).forEach(filed -> {
               if(!filed.getName().equals("serialVersionUID")){
                   try {
                       String fieldsName = filed.getName();
                       char[] cs = fieldsName.toCharArray();
                       cs[0]-=32;
                       fieldsName = "get"+String.valueOf(cs);
                       Method method = obj.getClass().getMethod(fieldsName,new Class[]{});
                       params.put(filed.getName(), String.valueOf(method.invoke(obj,new Object[]{})));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
               }
           });
           pager.setParams(params);
           return (U) pager;
       }else{ //其他类型
           t = (U) JSONObject.parse(JSONObject.toJSONString(obj));
       }
       return t;
    };

    /**
     * @param <T>
     * @param <T>
     * @Description (查询注单记录)
     * @param pager
     * @return
     */
    public <T> Pager<T> list(Pager<T> pager);

}
