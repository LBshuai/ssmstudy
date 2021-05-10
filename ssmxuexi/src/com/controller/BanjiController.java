package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Banji;
import com.service.BanjiService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class BanjiController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	BanjiService banjiService;
@Autowired
HttpServletRequest request;
//班级列表管理页面
	@RequestMapping("banjilist")
	public String listBanji(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Banji> cs= banjiService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Banji banji=(Banji)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Banji> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/banji/banjilist";
	}

	@RequestMapping("banjiadd")
	public String addbanji(Model model){

	return "pages/banji/banjiadd";
	}
	//添加班级数据
	@RequestMapping("banjiinsert")
	public String insertBanji(Banji banji,Model model){
	String forword=request.getParameter("forword");
		banjiService.insert(banji);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除班级数据
	@RequestMapping("banjidel")
	public String deleteBanji(Banji banji,Model model){
		String forword=request.getParameter("forword");
		banjiService.delete(banji);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的班级数据
	@RequestMapping("banjiedit")
	public String editBanji(Model model,Banji banji){
		Banji c= banjiService.get(banji.getId());

		model.addAttribute("c", c);
		return "pages/banji/banjiedit";
	}

	//修改的班级数据
	@RequestMapping("banjiupdate")
	public String updateBanji(Banji banji,Model model){
		String forword=request.getParameter("forword");
		banjiService.update(banji);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//班级所有列表页
	@RequestMapping("banjiAll")
	public String listBanjiAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Banji> cs= banjiService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Banji banji=(Banji)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Banji> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/banji/banjiAll";
	}
}