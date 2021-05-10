package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Teacher;
import com.service.TeacherService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class TeacherController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	TeacherService teacherService;
@Autowired
HttpServletRequest request;
//教师列表管理页面
	@RequestMapping("teacherlist")
	public String listTeacher(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

		List<Teacher> cs= teacherService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Teacher teacher=(Teacher)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Teacher> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/teacher/teacherlist";
	}

	@RequestMapping("teacheradd")
	public String addteacher(Model model){

	return "pages/teacher/teacheradd";
	}
	//添加教师数据
	@RequestMapping("teacherinsert")
	public String insertTeacher(Teacher teacher,Model model){
	String forword=request.getParameter("forword");
		teacherService.insert(teacher);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除教师数据
	@RequestMapping("teacherdel")
	public String deleteTeacher(Teacher teacher,Model model){
		String forword=request.getParameter("forword");
		teacherService.delete(teacher);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的教师数据
	@RequestMapping("teacheredit")
	public String editTeacher(Model model,Teacher teacher){
		Teacher c= teacherService.get(teacher.getId());

		model.addAttribute("c", c);
		return "pages/teacher/teacheredit";
	}

	//修改的教师数据
	@RequestMapping("teacherupdate")
	public String updateTeacher(Teacher teacher,Model model){
		String forword=request.getParameter("forword");
		teacherService.update(teacher);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//教师所有列表页
	@RequestMapping("teacherAll")
	public String listTeacherAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("tel")) && request.getParameter("tel") !=null)
w=w+ " and tel like '%"+request.getParameter("tel")+"%'";

		List<Teacher> cs= teacherService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Teacher teacher=(Teacher)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Teacher> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/teacher/teacherAll";
	}
//注册
@RequestMapping("teacherreg")
	public String insertreg(Teacher teacher,Model model){
	String forword=request.getParameter("forword");
	String w=" and username='"+request.getParameter("username")+"'";
	List<Teacher> cs= teacherService.list(w);
	if (cs.size()>0)
	{
		model.addAttribute("msg","用户名重复!请重试");
		model.addAttribute("path",forword);		
	}
	else{
		teacherService.insert(teacher);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	}
		return "success";
	
	}
//修改个人资料
	@RequestMapping("teacherinfo")
	public String editTeacherinfo(Model model,Teacher teacher){
Teacher c= teacherService.get(teacher.getId());

		model.addAttribute("c", c);
		return "pages/teacher/teacherinfo";
	}

	//保存修改个人资料数据
	@RequestMapping("teacherinfosave")
	public String Teacherinfosave(Teacher teacher,Model model){
		String forword=request.getParameter("forword");
		teacherService.update(teacher);
model.addAttribute("msg","修改成功");
 model.addAttribute("path",forword);
		return "success";
	}
}