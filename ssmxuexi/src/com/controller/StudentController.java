package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Student;
import com.service.StudentService;
import com.entity.Banji;
import com.service.BanjiService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class StudentController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	StudentService studentService;
	@Autowired
	BanjiService banjiService;
@Autowired
HttpServletRequest request;
//学生列表管理页面
	@RequestMapping("studentlist")
	public String listStudent(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("banji")) && request.getParameter("banji") !=null)
			w=w+ " and banji  = '"+request.getParameter("banji")+"'";

		List<Student> cs= studentService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Student student=(Student)cs.get(i);
}
	List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Student> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/student/studentlist";
	}

	@RequestMapping("studentadd")
	public String addstudent(Model model){
	List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);

	return "pages/student/studentadd";
	}
	
	@RequestMapping("sreg")
	public String stureg(Model model){
	List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);

	return "pages/student/studentreg";
	}
	//添加学生数据
	@RequestMapping("studentinsert")
	public String insertStudent(Student student,Model model){
	String forword=request.getParameter("forword");
		studentService.insert(student);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除学生数据
	@RequestMapping("studentdel")
	public String deleteStudent(Student student,Model model){
		String forword=request.getParameter("forword");
		studentService.delete(student);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的学生数据
	@RequestMapping("studentedit")
	public String editStudent(Model model,Student student){
		Student c= studentService.get(student.getId());
List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);

		model.addAttribute("c", c);
		return "pages/student/studentedit";
	}

	//修改的学生数据
	@RequestMapping("studentupdate")
	public String updateStudent(Student student,Model model){
		String forword=request.getParameter("forword");
		studentService.update(student);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//学生所有列表页
	@RequestMapping("studentAll")
	public String listStudentAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("banji")) && request.getParameter("banji") !=null)
			w=w+ " and banji  = '"+request.getParameter("banji")+"'";

		List<Student> cs= studentService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Student student=(Student)cs.get(i);
}
	List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Student> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/student/studentAll";
	}
//注册
@RequestMapping("studentreg")
	public String insertreg(Student student,Model model){
	String forword=request.getParameter("forword");
	String w=" and username='"+request.getParameter("username")+"'";
	List<Student> cs= studentService.list(w);
	if (cs.size()>0)
	{
		model.addAttribute("msg","用户名重复!请重试");
		model.addAttribute("path",forword);		
	}
	else{
		studentService.insert(student);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
	}
		return "success";
	
	}
//修改个人资料
	@RequestMapping("studentinfo")
	public String editStudentinfo(Model model,Student student){
Student c= studentService.get(student.getId());
List<Banji> banji= banjiService.list("");
		// 放入转发参数
		model.addAttribute("banji", banji);

		model.addAttribute("c", c);
		return "pages/student/studentinfo";
	}

	//保存修改个人资料数据
	@RequestMapping("studentinfosave")
	public String Studentinfosave(Student student,Model model){
		String forword=request.getParameter("forword");
		studentService.update(student);
model.addAttribute("msg","修改成功");
 model.addAttribute("path",forword);
		return "success";
	}
}