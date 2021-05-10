package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Student;
import com.mapper.StudentMapper;
@Service
public class StudentService{
	@Autowired
	StudentMapper studentMapper;
	
	public List<Student> list(String where){
		return studentMapper.list(where);
	}
	public List<Student> sealist(String where) {
		// TODO Auto-generated method stub
		return studentMapper.sealist(where);
	}

	public int total() {
		return studentMapper.total();
	}

	
	public void insert(Student c) {
		studentMapper.insert(c);
		
	}


	public void update(Student c) {
		studentMapper.update(c);
	}


	public void delete(Student c) {
		studentMapper.delete(c.getId());
	}


	public Student get(int id) {
		// TODO Auto-generated method stub
		return studentMapper.get(id);
	}

   public void updatesql(String value) {
		studentMapper.updatesql(value);
	}
	public void deletesql(String value) {
		studentMapper.deletesql(value);
	}
}