<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<jsp:include flush="true" page="/pages/header.jsp"></jsp:include>
	      <script type="text/javascript" src="<%=path%>/pages/themes/js/superslide.js"></script>

<!-- index1-div1 -->
<div id="index1-div1" class="clearfix">
	<div class="index1-left675">
    	<div class="title-box">网站公告</div>
        <p>    <div id="slideBox" class="slideBox">
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
  
    <ul>  		
    
      <c:forEach items="${requestScope.indexlist}" var="c"  varStatus="ss">

      <li><a href="<%=path%>/noticeview?id=${c.id}"><strong>${c.title}</strong></a>
      
      </li> </c:forEach>         
          </ul>
        
      
      
</p>
    </div>
    <div class="index1-right300">
    	<div class="title-box">练习题下载
    	<a href="<%=path %>/ziliaoAll?leixing=练习题" class="title-more" title="查看更多"><img src="images/12.gif"></a></div>
          <ul>
     <c:forEach items="${lianxi}" var="s">
      <li><a href="<%=path %>/ziliaoview?id=${s.id }">${s.name }</a> </li>
     </c:forEach>          
          </ul>
    </div>
</div>
<!-- index1-div2 -->
<div id="index1-div2" class="clearfix">
	<div class="index1-left675">
    	<div class="index1-li-box">
    	<div class="index1-left330">
        	<div class="title-box">最新课件<a href="<%=path %>/ziliaoAll?leixing=课件"" class="title-more" title="查看更多">
        	<img src="<%=path %>/images/12.gif"></a></div>
            <ul>
             <c:forEach items="${kejian}" var="s">
      <li><a href="<%=path %>/ziliaoview?id=${s.id }">${s.name }</a> <span></span></li>
     </c:forEach>
         
            </ul>
        </div>
        <div class="index1-right330">
        	<div class="title-box">教学视频<a href="<%=path %>/videoAll" class="title-more" title="查看更多"><img src="<%=path %>/images/12.gif"></a></div>
            <ul>
                 <c:forEach items="${v}" var="s">
      <li><a href="<%=path %>/videoview?id=${s.id }">${s.name }</a><span></span> </li>
     </c:forEach>
            </ul>
        </div>
        </div>
       
    </div>
    <div class="index1-right300">
        <div class="index1-login-box">
          <div class="title-box">学生登录</div>
     <c:if test="${sessionScope.userType ne 1}">

          
          <form id="userLogin" name="userLogin" method="post">
            <input type="text" name="userName" id="userName" placeholder="用户名" class="index1-uname">
            <input type="password" name="userPw" id="userPw" placeholder="密码" class="index1-upass">
                    <div class="index1-t-link">
</div>
            <input type="button" name="submit" id="log"  value="登录"  class="index1-input-login">
            <input type="button" name="button" id="button" value="注册" class="index1-input-but" onclick="location.href='<%=path%>/sreg'">
	<span id="msg">${msg}</span>   
<input type="hidden"  name="userType" id="userType" value="1"/>          </form>
         </c:if>
		    
     <c:if test="${sessionScope.userType eq 1}">
		        <br/>
			     欢迎您： ${sessionScope.loginname } &nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;
 <br/> | <a href="<%=path %>/liuyanadd">在线留言</a><br/>

| <a href="<%=path %>/liuyanmy">我的留言</a><br/>

| <a href="<%=path %>/studentinfo?id=${sessionScope.loginid }">修改资料</a><br/>
| <a href="<%=path %>/userLogout">注销登录</a><br/>
			    <br/><br/>
		</c:if>
        </div>
		
    </div>
</div>
<!-- div5 -->
<div id="div5" class="clearfix">
    
</div>
<script language="javascript">
$(function(){
$("#log").on('click',function(event) {
var username = $("input[name='userName']").val();
var pwd = $("input[name='userPw']").val();
var userType =  $('#userType').val();
if(username==''){
	alert("用户名不能为空！");
			//$('#msg').addClass('text-danger').text('用户名不能为空！');
			return false;
		}
		if(pwd==''){
				alert("密码不能为空!");

			//$('#msg').addClass('text-danger').text('密码不能为空！');
			return false;
		}
	$.ajax({
			url: '<%=path%>/check',
			type: 'post',
			data: {"username": username,"pwd": pwd,"userType":userType},
			beforeSend: function(){
				$('#msg').addClass('text-success').text('正在登录...');
				//$(".log").attr('disabled',true);
			},
			dataType: 'json',
				success: function(rs){
				var status=rs.status;
				var msg=rs.msg;
			//	alert(msg);
				if(status=="1"){ //登录成功
					alert(msg);
					$('#msg').removeClass('text-danger').addClass('text-success').text('登录成功！');
					if(userType==1)
				location.href='<%=path%>/index';
				else
					location.href='<%=path%>/pages/adminindex.jsp';

				}else{
				alert(msg);
					$('#msg').addClass('text-danger').text('用户名或密码错误！');
				}
			},
			error:function(){
				alert("发生登录异常");
			}
		});

});
});
		
		
	    </script>

 <script type="text/javascript">
	jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
</script>
<jsp:include flush="true" page="/pages/footer.jsp"></jsp:include>
