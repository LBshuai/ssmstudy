<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
if (request.getParameter("msg")=="1")
{
	//alert("");
}
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>网上学习系统</title>
    <!-- Bootstrap -->
    
	 <link href="<%=path %>/css/css.css" rel="stylesheet">
  	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script src="<%=path %>/js/laydate/laydate.js"></script>
 <script src="<%=path %>/ueditor/ueditor.config.js"></script>
       <script src="<%=path %>/ueditor/ueditor.all.js"></script>
  <script src="<%=path %>/layer/layer.js"></script>
	<script type="text/javascript">
		</script>
	      <script type="text/javascript" src="<%=path%>/pages/themes/js/superslide.js"></script>
	 <link href="<%=path %>/pages/themes/css/css.css" rel="stylesheet">

</head><body>
  <div class="wrapper">
<div class="header">
  <a href="<%=path%>/index"><img src="<%=path%>/pages/images/logo.jpg" height="236" width="960" /></a>
</div>
<div class ="daohang">
  <p><a href ="<%=path%>/index" style="color:#ff0; font-size: 16px">网站首页</a></p>
  <p><a href ="<%=path%>/noticeAll" style="color:#ff0; font-size: 16px">新闻公告</a></p>
    <p><a href ="<%=path%>/ziliaoAll?leixing=课件" style="color:#ff0; font-size: 16px">课件列表</a></p>
        <p><a href ="<%=path%>/ziliaoAll?leixing=练习题" style="color:#ff0; font-size: 16px">练习题下载</a></p>
    
      <p><a href ="<%=path%>/videoAll" style="color:#ff0; font-size: 16px">教学视频</a></p>
  
     <c:if test="${sessionScope.userType ne 1}">
  <p><a href ="<%=path%>/sreg" style="color:#ff0; font-size: 16px">学生注册</a></p>

    <p><a href ="<%=path%>/pages/login.jsp" style="color:#ff0; font-size: 16px">用户登录</a></p>
</c:if>
     <c:if test="${sessionScope.userType eq 1}">
    <p><a href ="<%=path%>/kaishikaoshi" style="color:#ff0; font-size: 16px">在线考试</a></p>

</c:if>

</div>

    <div class="clear"></div>
          <div style="width:950px;margin:0 auto;">
     <c:if test="${sessionScope.userType==1}">
你好， ${sessionScope.loginname }。欢迎登录！


| <a href="<%=path %>/liuyanadd">在线留言</a>

| <a href="<%=path %>/liuyanmy">我的留言</a>

| <a href="<%=path %>/studentinfo?id=${sessionScope.loginid }">修改资料</a>
| <a href="<%=path %>/userLogout">注销登录</a>
</c:if>
<br><br>
</div>


 