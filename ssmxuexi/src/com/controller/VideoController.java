package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Video;
import com.service.VideoService;
import com.entity.Kinfo;
import com.service.KinfoService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class VideoController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	VideoService videoService;
	@Autowired
	KinfoService kinfoService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("videomy")
	public String listVideomy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("kinfo")) && request.getParameter("kinfo") !=null)
			w=w+ " and kinfo  = "+request.getParameter("kinfo")+"";

		List<Video> cs= videoService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Video video=(Video)cs.get(i);
video.setKinfofk(kinfoService.get(video.getKinfo()));
}
	List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Video> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/video/videomy";
	}
//教学视频列表管理页面
	@RequestMapping("videolist")
	public String listVideo(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("kinfo")) && request.getParameter("kinfo") !=null)
			w=w+ " and kinfo  = "+request.getParameter("kinfo")+"";

		List<Video> cs= videoService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Video video=(Video)cs.get(i);
video.setKinfofk(kinfoService.get(video.getKinfo()));
}
	List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Video> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		
		return "pages/video/videolist";
	}

	@RequestMapping("videoadd")
	public String addvideo(Model model){
	List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);

	return "pages/video/videoadd";
	}
	//添加教学视频数据
	@RequestMapping("videoinsert")
	public String insertVideo(Video video,Model model){
	String forword=request.getParameter("forword");
		videoService.insert(video);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除教学视频数据
	@RequestMapping("videodel")
	public String deleteVideo(Video video,Model model){
		String forword=request.getParameter("forword");
		videoService.delete(video);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的教学视频数据
	@RequestMapping("videoedit")
	public String editVideo(Model model,Video video){
		Video c= videoService.get(video.getId());
List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);

		model.addAttribute("c", c);
		return "pages/video/videoedit";
	}

	//修改的教学视频数据
	@RequestMapping("videoupdate")
	public String updateVideo(Video video,Model model){
		String forword=request.getParameter("forword");
		videoService.update(video);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//教学视频所有列表页
	@RequestMapping("videoAll")
	public String listVideoAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("kinfo")) && request.getParameter("kinfo") !=null)
			w=w+ " and kinfo  = "+request.getParameter("kinfo")+"";

		List<Video> cs= videoService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Video video=(Video)cs.get(i);
video.setKinfofk(kinfoService.get(video.getKinfo()));
}
	List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Video> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/video/videoAll";
	}

@RequestMapping("videoview")
public String viewVideo(Model model,Video video){
Video c= videoService.get(video.getId());
c.setKinfofk(kinfoService.get(c.getKinfo()));
model.addAttribute("c", c);
return "pages/video/videoview";
}
}