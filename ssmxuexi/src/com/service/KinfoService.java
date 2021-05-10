package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Kinfo;
import com.mapper.KinfoMapper;
@Service
public class KinfoService{
	@Autowired
	KinfoMapper kinfoMapper;
	
	public List<Kinfo> list(String where){
		return kinfoMapper.list(where);
	}
	public List<Kinfo> sealist(String where) {
		// TODO Auto-generated method stub
		return kinfoMapper.sealist(where);
	}

	public int total() {
		return kinfoMapper.total();
	}

	
	public void insert(Kinfo c) {
		kinfoMapper.insert(c);
		
	}


	public void update(Kinfo c) {
		kinfoMapper.update(c);
	}


	public void delete(Kinfo c) {
		kinfoMapper.delete(c.getId());
	}


	public Kinfo get(int id) {
		// TODO Auto-generated method stub
		return kinfoMapper.get(id);
	}

   public void updatesql(String value) {
		kinfoMapper.updatesql(value);
	}
	public void deletesql(String value) {
		kinfoMapper.deletesql(value);
	}
}