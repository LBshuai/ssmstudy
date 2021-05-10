package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Kinfo;
import com.service.KinfoService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class KinfoController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	KinfoService kinfoService;
@Autowired
HttpServletRequest request;
//课程列表管理页面
	@RequestMapping("kinfolist")
	public String listKinfo(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Kinfo> cs= kinfoService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Kinfo kinfo=(Kinfo)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Kinfo> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/kinfo/kinfolist";
	}

	@RequestMapping("kinfoadd")
	public String addkinfo(Model model){

	return "pages/kinfo/kinfoadd";
	}
	//添加课程数据
	@RequestMapping("kinfoinsert")
	public String insertKinfo(Kinfo kinfo,Model model){
	String forword=request.getParameter("forword");
		kinfoService.insert(kinfo);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除课程数据
	@RequestMapping("kinfodel")
	public String deleteKinfo(Kinfo kinfo,Model model){
		String forword=request.getParameter("forword");
		kinfoService.delete(kinfo);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的课程数据
	@RequestMapping("kinfoedit")
	public String editKinfo(Model model,Kinfo kinfo){
		Kinfo c= kinfoService.get(kinfo.getId());

		model.addAttribute("c", c);
		return "pages/kinfo/kinfoedit";
	}

	//修改的课程数据
	@RequestMapping("kinfoupdate")
	public String updateKinfo(Kinfo kinfo,Model model){
		String forword=request.getParameter("forword");
		kinfoService.update(kinfo);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//课程所有列表页
	@RequestMapping("kinfoAll")
	public String listKinfoAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Kinfo> cs= kinfoService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Kinfo kinfo=(Kinfo)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Kinfo> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/kinfo/kinfoAll";
	}
}