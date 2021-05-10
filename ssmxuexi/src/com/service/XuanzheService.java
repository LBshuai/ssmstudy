package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Xuanzhe;
import com.mapper.XuanzheMapper;
@Service
public class XuanzheService{
	@Autowired
	XuanzheMapper xuanzheMapper;
	
	public List<Xuanzhe> list(String where){
		return xuanzheMapper.list(where);
	}
	public List<Xuanzhe> sealist(String where) {
		// TODO Auto-generated method stub
		return xuanzheMapper.sealist(where);
	}

	public int total() {
		return xuanzheMapper.total();
	}

	
	public void insert(Xuanzhe c) {
		xuanzheMapper.insert(c);
		
	}


	public void update(Xuanzhe c) {
		xuanzheMapper.update(c);
	}


	public void delete(Xuanzhe c) {
		xuanzheMapper.delete(c.getId());
	}


	public Xuanzhe get(int id) {
		// TODO Auto-generated method stub
		return xuanzheMapper.get(id);
	}

   public void updatesql(String value) {
		xuanzheMapper.updatesql(value);
	}
	public void deletesql(String value) {
		xuanzheMapper.deletesql(value);
	}
}