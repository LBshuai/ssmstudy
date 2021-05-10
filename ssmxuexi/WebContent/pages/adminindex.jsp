<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/css.css" />
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sdmenu.js"></script>

</head>

<body>
<div class="header">
	 <div class="logo">管理系统</div>
     
				<div class="header-right">
                 <!--  <i class="icon-question-sign icon-white"></i> <a href="#" style="font-size:18px">关于系统</a>  --->
				   <i class="icon-question-sign icon-white"></i> 
				   <a href="#" style="font-size:16px">欢迎你:
				   <c:if test="${sessionScope.userType==0}">
                       管理员 
	                </c:if>
	               		   <c:if test="${sessionScope.userType ne 0}">
                     ${sessionScope.loginname}
	                </c:if>
	                </strong>,</a>
				   <i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal" style="font-size:18px">注销</a> 
                <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						注销系统
					</h3>
				</div>
				<div class="modal-body">
					<p>
						您确定要注销退出系统吗？
					</p>
				</div>
				<div class="modal-footer">
					 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="<%=path %>/userLogout" target="_top" >确定退出</a>
				</div>
			</div>
				</div>
</div>
<!-- 顶部 -->     
            
<div id="middle">
     <div class="left">
     
     <script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">
					   <c:if test="${sessionScope.userType==0}">

<!--开始-->
 <div class="collapsed">
 <span>新闻公告管理</span>
         <a target="manFrame" href="<%=path %>/noticelist">新闻公告管理</a> 
      <a target="manFrame" href="<%=path %>/noticeadd">新闻公告添加</a> 
    </div>
	<!--结束-->
 <div class="collapsed">
 <span>教学视频管理</span>
         <a target="manFrame" href="<%=path %>/videolist">教学视频管理</a> 
    </div>
<!--开始-->
<!--开始-->
 <div class="collapsed">
 <span>资料管理</span>
         <a target="manFrame" href="<%=path %>/ziliaolist">资料管理</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>管理员管理</span>
         <a target="manFrame" href="<%=path %>/adminlist">管理员管理</a> 
      <a target="manFrame" href="<%=path %>/adminadd">管理员添加</a> 
    </div>
	<!--结束-->
<div class="collapsed">
 <span>课程管理</span>
         <a target="manFrame" href="<%=path %>/kinfolist">课程管理</a> 
      <a target="manFrame" href="<%=path %>/kinfoadd">课程添加</a> 
    </div>
	<!--结束-->
<div class="collapsed">
 <span>班级管理</span>
         <a target="manFrame" href="<%=path %>/banjilist">班级管理</a> 
      <a target="manFrame" href="<%=path %>/banjiadd">班级添加</a> 
    </div>
	<!--结束-->



<!--开始-->
 <div class="collapsed">
 <span>学生管理</span>
         <a target="manFrame" href="<%=path %>/studentlist">学生管理</a> 
      <a target="manFrame" href="<%=path %>/studentadd">学生添加</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>教师管理</span>
         <a target="manFrame" href="<%=path %>/teacherlist">教师管理</a> 
      <a target="manFrame" href="<%=path %>/teacheradd">教师添加</a> 
    </div>
	<!--结束-->
<!--开始-->


</c:if>
<c:if test="${sessionScope.userType==2}">
 <div class="collapsed">
 <span>留言管理</span>
         <a target="manFrame" href="<%=path %>/liuyanlist">留言管理</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>教学视频管理</span>
         <a target="manFrame" href="<%=path %>/videomy">教学视频管理</a> 
      <a target="manFrame" href="<%=path %>/videoadd">教学视频添加</a> 
    </div>
<!--开始-->
<!--开始-->
 <div class="collapsed">
 <span>资料管理</span>
         <a target="manFrame" href="<%=path %>/ziliaomy">资料管理</a> 
      <a target="manFrame" href="<%=path %>/ziliaoadd">资料添加</a> 
    </div>
	<!--结束-->
 <div class="collapsed">
 <span>试题管理</span>
         <a target="manFrame" href="<%=path %>/xuanzhelist">试题管理</a> 
      <a target="manFrame" href="<%=path %>/xuanzheadd">试题添加</a> 
    </div>
	<!--结束-->


					   <!--开始-->
 <div class="collapsed">
 <span>修改个人资料</span>
              <a target="manFrame" href="<%=path %>/teacherinfo?id=${sessionScope.loginid}">修改</a> 
        
    </div>
	<!--结束-->

</c:if>

	</div>
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>

     <div class="right"  id="mainFrame">
     
     <div class="right_cont">
  <iframe scrolling="auto" frameborder="0" src="right.jsp" name="manFrame" style="margin:0 auto;" width="100%" height="820"></iframe>

 
</div>
     
     
     </div>     
     </div>
    </div>
    
<!-- 底部 -->
    
    





 
</body>
</html>
