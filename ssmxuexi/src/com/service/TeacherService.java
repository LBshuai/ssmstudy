package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Teacher;
import com.mapper.TeacherMapper;
@Service
public class TeacherService{
	@Autowired
	TeacherMapper teacherMapper;
	
	public List<Teacher> list(String where){
		return teacherMapper.list(where);
	}
	public List<Teacher> sealist(String where) {
		// TODO Auto-generated method stub
		return teacherMapper.sealist(where);
	}

	public int total() {
		return teacherMapper.total();
	}

	
	public void insert(Teacher c) {
		teacherMapper.insert(c);
		
	}


	public void update(Teacher c) {
		teacherMapper.update(c);
	}


	public void delete(Teacher c) {
		teacherMapper.delete(c.getId());
	}


	public Teacher get(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.get(id);
	}

   public void updatesql(String value) {
		teacherMapper.updatesql(value);
	}
	public void deletesql(String value) {
		teacherMapper.deletesql(value);
	}
}