package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Bhelp;
public interface BhelpMapper {
    //添加
    public int insert(Bhelp bhelp);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Bhelp get(int id);  
    //修改
    public int update(Bhelp bhelp);   
     //列表
    public List<Bhelp> list(@Param("where") String where);
    //分页
    public List<Bhelp> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}