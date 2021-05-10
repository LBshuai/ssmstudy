package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Xuanzhe;
import com.service.XuanzheService;
import com.entity.Kinfo;
import com.service.KinfoService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class XuanzheController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	XuanzheService xuanzheService;
	@Autowired
	KinfoService kinfoService;
@Autowired
HttpServletRequest request;
//选择题列表管理页面
	@RequestMapping("xuanzhelist")
	public String listXuanzhe(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("kinfo")) && request.getParameter("kinfo") !=null)
			w=w+ " and kinfo  = "+request.getParameter("kinfo")+"";

if (!"".equals(request.getParameter("daan")) && request.getParameter("daan") !=null)
w=w+ " and daan like '%"+request.getParameter("daan")+"%'";

if (!"".equals(request.getParameter("fenshu")) && request.getParameter("fenshu") !=null)
w=w+ " and fenshu like '%"+request.getParameter("fenshu")+"%'";

if (!"".equals(request.getParameter("jiexi")) && request.getParameter("jiexi") !=null)
w=w+ " and jiexi like '%"+request.getParameter("jiexi")+"%'";

		List<Xuanzhe> cs= xuanzheService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Xuanzhe xuanzhe=(Xuanzhe)cs.get(i);
xuanzhe.setKinfofk(kinfoService.get(xuanzhe.getKinfo()));
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
		         List<Xuanzhe> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/xuanzhe/xuanzhelist";
	}

	@RequestMapping("xuanzheadd")
	public String addxuanzhe(Model model){
	List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);

	return "pages/xuanzhe/xuanzheadd";
	}
	//添加选择题数据
	@RequestMapping("xuanzheinsert")
	public String insertXuanzhe(Xuanzhe xuanzhe,Model model){
	String forword=request.getParameter("forword");
		xuanzheService.insert(xuanzhe);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除选择题数据
	@RequestMapping("xuanzhedel")
	public String deleteXuanzhe(Xuanzhe xuanzhe,Model model){
		String forword=request.getParameter("forword");
		xuanzheService.delete(xuanzhe);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的选择题数据
	@RequestMapping("xuanzheedit")
	public String editXuanzhe(Model model,Xuanzhe xuanzhe){
		Xuanzhe c= xuanzheService.get(xuanzhe.getId());
List<Kinfo> kinfo= kinfoService.list("");
		// 放入转发参数
		model.addAttribute("kinfo", kinfo);

		model.addAttribute("c", c);
		return "pages/xuanzhe/xuanzheedit";
	}

	//修改的选择题数据
	@RequestMapping("xuanzheupdate")
	public String updateXuanzhe(Xuanzhe xuanzhe,Model model){
		String forword=request.getParameter("forword");
		xuanzheService.update(xuanzhe);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//选择题所有列表页
	@RequestMapping("xuanzheAll")
	public String listXuanzheAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("kinfo")) && request.getParameter("kinfo") !=null)
			w=w+ " and kinfo  = "+request.getParameter("kinfo")+"";

if (!"".equals(request.getParameter("daan")) && request.getParameter("daan") !=null)
w=w+ " and daan like '%"+request.getParameter("daan")+"%'";

if (!"".equals(request.getParameter("fenshu")) && request.getParameter("fenshu") !=null)
w=w+ " and fenshu like '%"+request.getParameter("fenshu")+"%'";

if (!"".equals(request.getParameter("jiexi")) && request.getParameter("jiexi") !=null)
w=w+ " and jiexi like '%"+request.getParameter("jiexi")+"%'";

		List<Xuanzhe> cs= xuanzheService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Xuanzhe xuanzhe=(Xuanzhe)cs.get(i);
xuanzhe.setKinfofk(kinfoService.get(xuanzhe.getKinfo()));
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
		         List<Xuanzhe> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/xuanzhe/xuanzheAll";
	}
}