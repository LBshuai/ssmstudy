package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Video;
import com.mapper.VideoMapper;
@Service
public class VideoService{
	@Autowired
	VideoMapper videoMapper;
	
	public List<Video> list(String where){
		return videoMapper.list(where);
	}
	public List<Video> sealist(String where) {
		// TODO Auto-generated method stub
		return videoMapper.sealist(where);
	}

	public int total() {
		return videoMapper.total();
	}

	
	public void insert(Video c) {
		videoMapper.insert(c);
		
	}


	public void update(Video c) {
		videoMapper.update(c);
	}


	public void delete(Video c) {
		videoMapper.delete(c.getId());
	}


	public Video get(int id) {
		// TODO Auto-generated method stub
		return videoMapper.get(id);
	}

   public void updatesql(String value) {
		videoMapper.updatesql(value);
	}
	public void deletesql(String value) {
		videoMapper.deletesql(value);
	}
}