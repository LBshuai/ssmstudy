package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Banji;
public interface BanjiMapper {
    //添加
    public int insert(Banji banji);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Banji get(int id);  
    //修改
    public int update(Banji banji);   
     //列表
    public List<Banji> list(@Param("where") String where);
    //分页
    public List<Banji> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}