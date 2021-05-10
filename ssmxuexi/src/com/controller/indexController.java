package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Notice;
import com.entity.Video;
import com.entity.Ziliao;
import com.service.KinfoService;
import com.service.LeixingService;
import com.service.NoticeService;
import com.service.VideoService;
import com.service.ZiliaoService;
import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class indexController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	NoticeService noticeService;
	@Autowired
	VideoService videoService;
	@Autowired
	KinfoService kinfoService;
	@Autowired
	ZiliaoService ziliaoService;
	@Autowired
	LeixingService leixingService;
@Autowired
HttpServletRequest request;
//首页
	@RequestMapping("index")
	public String indexAll(Model model){
				HttpSession session=request.getSession();

String w="";
List<Notice> cs= noticeService.list(w);

	if(cs.size()>5)
		{
			cs=cs.subList(0, 5);
		}
	model.addAttribute("indexlist", cs);

	List<Video> v= videoService.list(w);
	if(v.size()>5)
	{
		v=v.subList(0, 5);
	}
	model.addAttribute("v", v);
	List<Ziliao> kejian= ziliaoService.list("and leixing='课件'");

	if(kejian.size()>5)
	{
		kejian=kejian.subList(0, 5);
	}
	model.addAttribute("kejian", kejian);
	List<Ziliao> lianxi= ziliaoService.list("and leixing='练习题'");

	if(lianxi.size()>5)
	{
		lianxi=lianxi.subList(0, 5);
	}
	model.addAttribute("lianxi", lianxi);
		//session.setAttribute("seacs", seacs);

	
		// 放入转发参数
		return "pages/index";
	}


}