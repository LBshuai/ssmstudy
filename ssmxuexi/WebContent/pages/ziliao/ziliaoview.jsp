<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
  <jsp:include flush="true" page="/pages/header.jsp"></jsp:include>
   <div style="width:950px;margin:0 auto">

<table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">详情 &nbsp; &nbsp;</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>


<tr>
<td class="text-right"> 资料名称：</td>
<td>${c.name }</td>
</tr>
<tr>
<td class="text-right"> 类型：</td>
<td>${c.leixing }</td>
</tr>
<tr><td class="text-right">课程</td><td>${c.kinfofk.name}</td></tr>

 <tr><td class="text-right">附件</td><td>
<c:if test="${not empty c.zfile}"><a href="<%=path %>${c.zfile}" class="btn btn-default" target="_blank">下载</a></c:if>
<c:if test="${empty c.zfile}">未上传</c:if>
</td></tr>

<tr>
<td class="text-right"> 资料介绍：</td>
<td>${c.jieshao }</td>
</tr>
<tr>
<td class="text-right"> 时间：</td>
<td>${c.addtime }</td>
</tr>
<tr>
<td class="text-right"> 用户：</td>
<td>${c.uname }</td>
</tr></thead></table> </body>
 </html> 