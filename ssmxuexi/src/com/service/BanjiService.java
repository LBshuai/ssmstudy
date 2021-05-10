package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Banji;
import com.mapper.BanjiMapper;
@Service
public class BanjiService{
	@Autowired
	BanjiMapper banjiMapper;
	
	public List<Banji> list(String where){
		return banjiMapper.list(where);
	}
	public List<Banji> sealist(String where) {
		// TODO Auto-generated method stub
		return banjiMapper.sealist(where);
	}

	public int total() {
		return banjiMapper.total();
	}

	
	public void insert(Banji c) {
		banjiMapper.insert(c);
		
	}


	public void update(Banji c) {
		banjiMapper.update(c);
	}


	public void delete(Banji c) {
		banjiMapper.delete(c.getId());
	}


	public Banji get(int id) {
		// TODO Auto-generated method stub
		return banjiMapper.get(id);
	}

   public void updatesql(String value) {
		banjiMapper.updatesql(value);
	}
	public void deletesql(String value) {
		banjiMapper.deletesql(value);
	}
}