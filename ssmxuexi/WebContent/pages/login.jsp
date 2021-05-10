<%@ page language="java" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="<%=path %>/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="<%=path %>/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
  	<script src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.SuperSlide.js"></script>



</head>

<body>


<div class="header">
  <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href="#">系统登陆</a></h1>
	<div class="headerNav">
			
	</div>
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform" action="" name="ThisForm" method="post" >
   <div class="fm-item">
	   <label for="logonId" class="form-label">系统登陆：</label>
	   <input type="text"  name="userName" maxlength="100" id="userName" class="i-text"    >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">登陆密码：</label>
	   <input type="password" value="" maxlength="100" name="userPw" id="userPw" class="i-text" >    
       <div class="ui-form-explain"></div>
  </div>
    <div class="fm-item">
	   <label for="logonId" class="form-label">选择身份：</label>
	  <select name="userType" id="userType" style="WIDTH: 130px">
			                        <option value="0">管理员</option>
			                        <option value="2">老师</option>
			                        <option value="1">学生</option>
			                    </select>   
       <div class="ui-form-explain"></div>
  </div>

  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="button" value=""  id="log" class="btn-login">
       <div class="ui-form-explain"></div>
  </div>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(<%=path %>/images/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
			<li style="background:url(<%=path %>/images/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
   <p> Copyright  , All Rights Reserved</p>
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

</body>
</html>
