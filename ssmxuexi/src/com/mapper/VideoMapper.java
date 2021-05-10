package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Video;
public interface VideoMapper {
    //添加
    public int insert(Video video);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Video get(int id);  
    //修改
    public int update(Video video);   
     //列表
    public List<Video> list(@Param("where") String where);
    //分页
    public List<Video> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}