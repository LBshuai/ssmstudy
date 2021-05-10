package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Kinfo;
public interface KinfoMapper {
    //添加
    public int insert(Kinfo kinfo);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Kinfo get(int id);  
    //修改
    public int update(Kinfo kinfo);   
     //列表
    public List<Kinfo> list(@Param("where") String where);
    //分页
    public List<Kinfo> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}