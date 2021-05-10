package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Bhelp;
import com.service.BhelpService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class BhelpController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	BhelpService bhelpService;
@Autowired
HttpServletRequest request;
//帮助信息列表管理页面
	@RequestMapping("bhelplist")
	public String listBhelp(Model model){
String w="";

if (!"".equals(request.getParameter("title")) && request.getParameter("title") !=null)
w=w+ " and title like '%"+request.getParameter("title")+"%'";

		List<Bhelp> cs= bhelpService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Bhelp bhelp=(Bhelp)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Bhelp> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/bhelp/bhelplist";
	}

	@RequestMapping("bhelpadd")
	public String addbhelp(Model model){

	return "pages/bhelp/bhelpadd";
	}
	//添加帮助信息数据
	@RequestMapping("bhelpinsert")
	public String insertBhelp(Bhelp bhelp,Model model){
	String forword=request.getParameter("forword");
		bhelpService.insert(bhelp);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除帮助信息数据
	@RequestMapping("bhelpdel")
	public String deleteBhelp(Bhelp bhelp,Model model){
		String forword=request.getParameter("forword");
		bhelpService.delete(bhelp);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的帮助信息数据
	@RequestMapping("bhelpedit")
	public String editBhelp(Model model,Bhelp bhelp){
		Bhelp c= bhelpService.get(bhelp.getId());

		model.addAttribute("c", c);
		return "pages/bhelp/bhelpedit";
	}

	//修改的帮助信息数据
	@RequestMapping("bhelpupdate")
	public String updateBhelp(Bhelp bhelp,Model model){
		String forword=request.getParameter("forword");
		bhelpService.update(bhelp);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//帮助信息所有列表页
	@RequestMapping("bhelpAll")
	public String listBhelpAll(Model model){
String w="";

if (!"".equals(request.getParameter("title")) && request.getParameter("title") !=null)
w=w+ " and title like '%"+request.getParameter("title")+"%'";

		List<Bhelp> cs= bhelpService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Bhelp bhelp=(Bhelp)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Bhelp> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/bhelp/bhelpAll";
	}

@RequestMapping("bhelpview")
public String viewBhelp(Model model,Bhelp bhelp){
Bhelp c= bhelpService.get(bhelp.getId());
model.addAttribute("c", c);
return "pages/bhelp/bhelpview";
}
}