package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Leixing;
public interface LeixingMapper {
    //添加
    public int insert(Leixing leixing);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Leixing get(int id);  
    //修改
    public int update(Leixing leixing);   
     //列表
    public List<Leixing> list(@Param("where") String where);
    //分页
    public List<Leixing> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}