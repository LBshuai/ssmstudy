package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Leixing;
import com.service.LeixingService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class LeixingController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	LeixingService leixingService;
@Autowired
HttpServletRequest request;
//资料类型列表管理页面
	@RequestMapping("leixinglist")
	public String listLeixing(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Leixing> cs= leixingService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Leixing leixing=(Leixing)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Leixing> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/leixing/leixinglist";
	}

	@RequestMapping("leixingadd")
	public String addleixing(Model model){

	return "pages/leixing/leixingadd";
	}
	//添加资料类型数据
	@RequestMapping("leixinginsert")
	public String insertLeixing(Leixing leixing,Model model){
	String forword=request.getParameter("forword");
		leixingService.insert(leixing);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除资料类型数据
	@RequestMapping("leixingdel")
	public String deleteLeixing(Leixing leixing,Model model){
		String forword=request.getParameter("forword");
		leixingService.delete(leixing);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的资料类型数据
	@RequestMapping("leixingedit")
	public String editLeixing(Model model,Leixing leixing){
		Leixing c= leixingService.get(leixing.getId());

		model.addAttribute("c", c);
		return "pages/leixing/leixingedit";
	}

	//修改的资料类型数据
	@RequestMapping("leixingupdate")
	public String updateLeixing(Leixing leixing,Model model){
		String forword=request.getParameter("forword");
		leixingService.update(leixing);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//资料类型所有列表页
	@RequestMapping("leixingAll")
	public String listLeixingAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Leixing> cs= leixingService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Leixing leixing=(Leixing)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Leixing> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/leixing/leixingAll";
	}
}