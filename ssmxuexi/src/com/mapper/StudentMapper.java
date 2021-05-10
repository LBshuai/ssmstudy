package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Student;
public interface StudentMapper {
    //添加
    public int insert(Student student);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Student get(int id);  
    //修改
    public int update(Student student);   
     //列表
    public List<Student> list(@Param("where") String where);
    //分页
    public List<Student> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}