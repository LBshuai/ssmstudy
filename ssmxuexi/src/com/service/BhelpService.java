package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Bhelp;
import com.mapper.BhelpMapper;
@Service
public class BhelpService{
	@Autowired
	BhelpMapper bhelpMapper;
	
	public List<Bhelp> list(String where){
		return bhelpMapper.list(where);
	}
	public List<Bhelp> sealist(String where) {
		// TODO Auto-generated method stub
		return bhelpMapper.sealist(where);
	}

	public int total() {
		return bhelpMapper.total();
	}

	
	public void insert(Bhelp c) {
		bhelpMapper.insert(c);
		
	}


	public void update(Bhelp c) {
		bhelpMapper.update(c);
	}


	public void delete(Bhelp c) {
		bhelpMapper.delete(c.getId());
	}


	public Bhelp get(int id) {
		// TODO Auto-generated method stub
		return bhelpMapper.get(id);
	}

   public void updatesql(String value) {
		bhelpMapper.updatesql(value);
	}
	public void deletesql(String value) {
		bhelpMapper.deletesql(value);
	}
}