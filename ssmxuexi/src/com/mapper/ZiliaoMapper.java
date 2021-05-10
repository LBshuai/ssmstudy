package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Ziliao;
public interface ZiliaoMapper {
    //添加
    public int insert(Ziliao ziliao);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Ziliao get(int id);  
    //修改
    public int update(Ziliao ziliao);   
     //列表
    public List<Ziliao> list(@Param("where") String where);
    //分页
    public List<Ziliao> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}