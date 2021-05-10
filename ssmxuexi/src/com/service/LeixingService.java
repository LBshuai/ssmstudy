package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Leixing;
import com.mapper.LeixingMapper;
@Service
public class LeixingService{
	@Autowired
	LeixingMapper leixingMapper;
	
	public List<Leixing> list(String where){
		return leixingMapper.list(where);
	}
	public List<Leixing> sealist(String where) {
		// TODO Auto-generated method stub
		return leixingMapper.sealist(where);
	}

	public int total() {
		return leixingMapper.total();
	}

	
	public void insert(Leixing c) {
		leixingMapper.insert(c);
		
	}


	public void update(Leixing c) {
		leixingMapper.update(c);
	}


	public void delete(Leixing c) {
		leixingMapper.delete(c.getId());
	}


	public Leixing get(int id) {
		// TODO Auto-generated method stub
		return leixingMapper.get(id);
	}

   public void updatesql(String value) {
		leixingMapper.updatesql(value);
	}
	public void deletesql(String value) {
		leixingMapper.deletesql(value);
	}
}