package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


import com.entity.Xuanzhe;


//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class kaoshiController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法

	@Autowired
	com.service.XuanzheService xuanzheService;
	
@Autowired
HttpServletRequest request;
@RequestMapping("jieguo")
//@ResponseBody

public String jieguo(Model model){
	
	
	return "pages/jieguo";
	
}
	@RequestMapping("kaishikaoshi")
	//@ResponseBody
	
	public String kaishikaoshi(Model model){
		
		String id=request.getParameter("id");
		//String w="and kinfo="+id;
		String w="";
		List<Xuanzhe> xzcs= xuanzheService.list(w);
		model.addAttribute("xuanzhe",xzcs);
		return "pages/kaishikaoshi";
		
	}
	@RequestMapping("jiaojuan")
	
	public String jiaojuan(Model model){
		String kid=request.getParameter("kid");
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		//String w="and kinfo="+kid;
		String w="";
		List<Xuanzhe> xzcs= xuanzheService.list(w);
		int fenshu=0;
		//选择题处理
		for(int i=0;i<xzcs.size();i++)
		{		//String kid=request.getParameter("kid");

			//Xuanzhe xuanzhe=(Xuanzhe)xzcs.get(i);
			String tmp1=request.getParameter("xzdaan"+String.valueOf(i));
			String tmp2=request.getParameter("xz"+String.valueOf(i));
			String xid=request.getParameter("xid"+String.valueOf(i));
			Xuanzhe c= xuanzheService.get(Integer.valueOf(xid));
			if ("".equals(tmp2) && tmp2==null)
			{	}
			else
			{
				if(c.getDaan().equals(tmp2))
				{
				fenshu=fenshu+c.getFenshu();
				}
			}
			
		}


		//保存成绩
				String shijian=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//赋值
				
				 model.addAttribute("msg","本次得分"+fenshu);
				 model.addAttribute("path","");

					return "pages/jieguo";

	}
}