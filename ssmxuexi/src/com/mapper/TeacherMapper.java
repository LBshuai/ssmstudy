package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Teacher;
public interface TeacherMapper {
    //添加
    public int insert(Teacher teacher);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Teacher get(int id);  
    //修改
    public int update(Teacher teacher);   
     //列表
    public List<Teacher> list(@Param("where") String where);
    //分页
    public List<Teacher> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}