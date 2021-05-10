<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<jsp:include flush="true" page="/pages/header.jsp"></jsp:include>


  <div id="slideBox" class="slideBox">
    <div class="hd">
      <ul>
      <c:forEach items="${requestScope.indexlist}" var="c"  varStatus="ss">
      
      <li>${ss.index+1}</li>
      </c:forEach>
      </ul>
    </div>
    <div class="bd">
      <ul>
            <c:forEach items="${requestScope.indexlist}" var="c"  varStatus="ss">
      
<li><a href="<%=path%>/noticeview?id=${c.id}"><img src="<%=path %>${c.pic}" /></a></li>
      
      </c:forEach>
      </ul>
    </div>
  </div>
  
  <div class="big_box">
    <div class="big_title">最新公告</div>
		<MARQUEE onmouseover=this.stop() onmouseout=this.start() scrollDelay=100 direction=up height="99%">

    <ul class="big_list">
               <c:forEach items="${requestScope.indexlist}" var="c"  varStatus="ss">

      <li><a href="<%=path%>/noticeview?id=${c.id}"><strong>${c.title}</strong></a>
        <p></p>
      </li>
  </c:forEach>
	</MARQUEE>
    </ul>
  </div>

<div class="clear"></div>
 <div class="box">
    <div class="title"><a href="<%=path %>/videoAll">教学视频</a></div>
    <ul class="list">
  <c:forEach items="${v}" var="s">
      <li><em></em><a href="<%=path %>/videoview?id=${s.id }">${s.name }</a> </li>
     </c:forEach>
    </ul>
  </div>
    <div class="box">
    <div class="title"><a href="<%=path %>/ziliaoAll?leixing=课件">课件</a></div>
    <ul class="list">
  <c:forEach items="${kejian}" var="s">
      <li><em></em><a href="<%=path %>/ziliaoview?id=${s.id }">${s.name }</a> </li>
     </c:forEach>
    </ul>
  </div>
   <div class="box">
    <div class="title"><a href="<%=path %>/ziliaoAll?leixing=练习题">练习题</a></div>
    <ul class="list">
  <c:forEach items="${lianxi}" var="s">
      <li><em></em><a href="<%=path %>/ziliaoview?id=${s.id }">${s.name }</a> </li>
     </c:forEach>
    </ul>
  </div>
<div style="padding-top:10px"></div>

  <script type="text/javascript">
	jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
</script>


<jsp:include flush="true" page="/pages/footer.jsp"></jsp:include>