<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

    <jsp:include flush="true" page="/pages/header.jsp"></jsp:include>
       <script>
        function down1(fujianPath,fujianYuashiMing)
        {
            var url="<%=path %>/upload/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
            url=encodeURI(url); 
            url=encodeURI(url); 
            window.open(url,"_self");
        }
        </script>
   <div style="width:950px;margin:0 auto">
<table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">详情 &nbsp; &nbsp;</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>


<tr>
<td class="text-right"> 视频名称：</td>
<td>${c.name }</td>
</tr>
<tr><td class="text-right">课程</td><td>${c.kinfofk.name}</td></tr>

 <tr><td class="text-right">附件</td><td>
<c:if test="${not empty c.fujian}">

  <a href="#" onclick="down1('${c.fujian}','${c.fujian }')"  class="btn btn-default" >下载视频</a>
<%-- <a href="<%=path %>/pages/bofang.jsp?zfile=${c.fujian}" class="btn btn-primary" target="_blank">播放</a> --%>

		<c:if test="${not empty c.fujian}">
		<a href="<%=path %>${c.fujian}" class="btn btn-default" target="_blank">观看</a>
		</c:if>
			<c:if test="${empty c.fujian}">未上传</c:if>
	
</c:if>
<c:if test="${empty c.fujian}">未上传</c:if>
</td></tr>


<tr>
<td class="text-right"> 视频介绍：</td>
<td>${c.jieshao }</td>
</tr>
<tr>
<td class="text-right"> 用户：</td>
<td>${c.uname }</td>
</tr>
<tr>
<td class="text-right"> 时间：</td>
<td>${c.addtime }</td>
</tr></thead></table> </body>
 </html> 