package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Ziliao;
import com.mapper.ZiliaoMapper;
@Service
public class ZiliaoService{
	@Autowired
	ZiliaoMapper ziliaoMapper;
	
	public List<Ziliao> list(String where){
		return ziliaoMapper.list(where);
	}
	public List<Ziliao> sealist(String where) {
		// TODO Auto-generated method stub
		return ziliaoMapper.sealist(where);
	}

	public int total() {
		return ziliaoMapper.total();
	}

	
	public void insert(Ziliao c) {
		ziliaoMapper.insert(c);
		
	}


	public void update(Ziliao c) {
		ziliaoMapper.update(c);
	}


	public void delete(Ziliao c) {
		ziliaoMapper.delete(c.getId());
	}


	public Ziliao get(int id) {
		// TODO Auto-generated method stub
		return ziliaoMapper.get(id);
	}

   public void updatesql(String value) {
		ziliaoMapper.updatesql(value);
	}
	public void deletesql(String value) {
		ziliaoMapper.deletesql(value);
	}
}