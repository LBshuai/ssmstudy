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
    <title>选择题 </title>
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
    alert("选择题名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.a.value=="")
  {
    alert("选项A不能为空！");
    document.formAdd.a.focus();
    return false;
  }

 if (document.formAdd.b.value=="")
  {
    alert("选项b不能为空！");
    document.formAdd.b.focus();
    return false;
  }

 if (document.formAdd.c.value=="")
  {
    alert("选项c不能为空！");
    document.formAdd.c.focus();
    return false;
  }

 if (document.formAdd.d.value=="")
  {
    alert("选项d不能为空！");
    document.formAdd.d.focus();
    return false;
  }

 if (document.formAdd.daan.value=="")
  {
    alert("正确答案不能为空！");
    document.formAdd.daan.focus();
    return false;
  }

 if (document.formAdd.fenshu.value=="")
  {
    alert("分数不能为空！");
    document.formAdd.fenshu.focus();
    return false;
  }

 if (document.formAdd.jiexi.value=="")
  {
    alert("答案解析不能为空！");
    document.formAdd.jiexi.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="<%=path %>/xuanzheinsert" class="form-horizontal" role="form">
	<fieldset> <legend>添加选择题</legend>	

<div class="form-group">
             <label class="col-sm-2 control-label" for="name">选择题名称</label>
              <div class="col-sm-4">
<input name="name" type="text" id="name" value="" placeholder="选择题名称" class="form-control" >
 

 </div>
	</div>
<script type="text/javascript">
function uppic()
		    {
 layer.open({
   type: 2,
 title: '上传',
  skin: 'layui-layer-rim', //加上边框
  area: ['420px', '340px'], //宽高
  content: '<%=path %>/upload/upload.jsp?upname=pic'
  ,btn: ['关闭'] //只是为了演示
});
		  	     
		    }
</script>
<!-- 
<div class="form-group">
   <label class="col-sm-2 control-label" for="pic">图片</label>
    <div class="col-sm-4">
	<input type="text" name="pic" id="pic" readonly class="form-control" placeholder="点击上传"/>
           <button type="button" class="btn  btn-primary" onclick="uppic()">点击上传</button>
			</div>
	</div>
 -->

   <div class="form-group">
   <label for="kinfo"  class="col-sm-2 control-label">所属课程</label>
       <div class="col-sm-2">
       <select name="kinfo" class="form-control">
   <c:forEach items="${kinfo}" var="s"  varStatus="ss">
   <option value="${s.id}">${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="a">选项A</label>
              <div class="col-sm-4">
<input name="a" type="text" id="a" value="" placeholder="选项A" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="b">选项B</label>
              <div class="col-sm-4">
<input name="b" type="text" id="b" value="" placeholder="选项B" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="c">选项C</label>
              <div class="col-sm-4">
<input name="c" type="text" id="c" value="" placeholder="选项C" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="d">选项D</label>
              <div class="col-sm-4">
<input name="d" type="text" id="d" value="" placeholder="选项D" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="daan">正确答案</label>
              <div class="col-sm-4">
<input name="daan" type="text" id="daan" value="" placeholder="正确答案" class="form-control" >
 

 </div>
	</div>

<div class="form-group">
   <label class="col-sm-2 control-label" for="fenshu">分数</label>
    <div class="col-sm-4">
<input name="fenshu" type="text" id="fenshu" value=""  class="form-control"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" >
</div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="jiexi">答案解析</label>
              <div class="col-sm-4">
<input name="jiexi" type="text" id="jiexi" value="" placeholder="答案解析" class="form-control" >
 

 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			       <input name="forword" type="hidden" value="xuanzhelist"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>
    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  