<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	</script>

  </head>
  
  <body leftmargin="0" topmargin="0" rightmargin="0">
  
  <script type='text/javascript' src='<%=path %>/js/swfobject.js'></script>
<div class='sVideo'><div id='CuPlayer'>
<strong>提示：你的Flash Player版本过低，请升级</strong>
</div></div>
<script type='text/javascript'>
var so = new SWFObject('<%=path %>/js/GrayPlayer.swf','CuPlayer','800','600','9','#000000');
so.addParam('allowfullscreen','true');
so.addParam('allowscriptaccess','always');
so.addParam('wmode','opaque');
so.addParam('quality','high');
so.addParam('salign','lt');
so.addVariable('CuPlayerFile','<%=path %>/<%=request.getParameter("zfile") %>');
so.addVariable('CuPlayerImage','upfile/');
so.addVariable('CuPlayerShowImage','true');
so.addVariable('CuPlayerWidth','800');
so.addVariable('CuPlayerHeight','600');
so.addVariable('CuPlayerAutoPlay','false');
so.addVariable('CuPlayerAutoRepeat','true');
so.addVariable('CuPlayerShowControl','true');
so.addVariable('CuPlayerAutoHideControl','false');
so.addVariable('CuPlayerAutoHideTime','6');
so.addVariable('CuPlayerVolume','80');
so.write('CuPlayer');
 </script>

  
    
  </body>
</html>
