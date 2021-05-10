<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>教学视频 </title>
    <!-- Bootstrap -->
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
<div class="container">


<script>
function check()
{

 if (document.formAdd.name.value=="")
  {
    alert("视频名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.jieshao.value=="")
  {
    alert("视频介绍不能为空！");
    document.formAdd.jieshao.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="<%=path %>/videoinsert" class="form-horizontal" role="form">
	<fieldset> <legend>添加教学视频</legend>	

<div class="form-group">
             <label class="col-sm-2 control-label" for="name">视频名称</label>
              <div class="col-sm-4">
<input name="name" type="text" id="name" value="" placeholder="视频名称" class="form-control" >
 

 </div>
	</div>
<script type="text/javascript">
function upfujian()
		    {
 layer.open({
   type: 2,
 title: '上传',
  skin: 'layui-layer-rim', //加上边框
  area: ['420px', '340px'], //宽高
  content: '<%=path %>/upload/upload.jsp?upname=fujian'
  ,btn: ['关闭'] //只是为了演示
});
		  	     
		    }
</script>
<div class="form-group">
   <label class="col-sm-2 control-label" for="fujian">附件</label>
    <div class="col-sm-4">
	<input type="text" name="fujian" id="fujian" readonly class="form-control" placeholder="点击上传"/>
           <button type="button" class="btn  btn-primary" onclick="upfujian()">点击上传</button>
			</div>
	</div>


   <div class="form-group">
   <label for="kinfo"  class="col-sm-2 control-label">课程</label>
       <div class="col-sm-2">
       <select name="kinfo" class="form-control">
   <c:forEach items="${kinfo}" var="s"  varStatus="ss">
   <option value="${s.id}">${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>
<div class="form-group">
   <label class="col-sm-2 control-label" for="jieshao">视频介绍</label>
    <div class="col-sm-4">
<textarea name="jieshao" id="jieshao" cols="50" rows="6"></textarea>
	                            <script type="text/javascript">
UE.getEditor('jieshao',{toolbars:[['FullScreen', 'Source','Undo', 'Redo','Bold','test']],wordCount:false,elementPathEnabled:false,
            initialFrameHeight:200,initialFrameWidth:340})   </script>
	</div>
	</div>
<input name="uname" type="hidden" value="${sessionScope.loginname}">

<input name="addtime" type="hidden" value ="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>">

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			       <input name="forword" type="hidden" value="videomy"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>
    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  