<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> <%
String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>网上学习系统</title>
<link rel="stylesheet" href="<%=path %>/css/style1.css" type="text/css" media="all"/>
  	<script src="<%=path %>/js/jquery.min.js"></script>

    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script src="<%=path %>/js/laydate/laydate.js"></script>
 <script src="<%=path %>/ueditor/ueditor.config.js"></script>
       <script src="<%=path %>/ueditor/ueditor.all.js"></script>
  <script src="<%=path %>/layer/layer.js"></script>
	
	
</head>

<body>
<div id="hearder2" class="clearfix">
	<div class="logo">
   	  <img src="<%=path %>/images/logo.png">
  </div>
  <div class="logo-name"></div>
  <div class="form-tools"><!--<form id="search" name="search" method="post">
      	<div class="tools-link">
        </div>
        <div class="search-box">
            <input type="text" name="textfield" id="textfield" class="input-text" placeholder="请输入搜索关键词">
            <input type="image" src="<%=path %>/images/search.png" class="input-submit" />
        </div>
  	  </form>  -->
   	  
    </div>
</div>
<div id="menu-box" class="clearfix">
	<ul>
    <li><a href ="<%=path%>/index">网站首页</a></li>
  <li><a href ="<%=path%>/noticeAll">新闻公告</a></li>
    <li><a href ="<%=path%>/ziliaoAll?leixing=课件">课件列表</a></li>
        <li><a href ="<%=path%>/ziliaoAll?leixing=练习题">练习题下载</a></li>
    
      <li><a href ="<%=path%>/videoAll">教学视频</a></li>
  
     <c:if test="${sessionScope.userType ne 1}">
  <li><a href ="<%=path%>/sreg">学生注册</a></li>

    <li><a href ="<%=path%>/pages/login.jsp">用户登录</a></li>
</c:if>
     <c:if test="${sessionScope.userType eq 1}">
    <li><a href ="<%=path%>/kaishikaoshi">在线考试</a></li>

</c:if>

      
    </ul>
</div>
<div id="slider-box" style="background:url(<%=path %>/images/slider1.jpg) center center;"></div>

