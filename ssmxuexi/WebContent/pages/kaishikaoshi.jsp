<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>
<jsp:include flush="true" page="/pages/header.jsp"></jsp:include>
<script language="JavaScript">
function func(num){
var x2;
x2=num+"b";
if(document.all[x2].style.display == "")
{
    document.all[x2].style.display = "none";
}
else if(document.all[x2].style.display == "none")
  document.all[x2].style.display = "";
 }

</script>
   <div style="width:950px;margin:0 auto">
   <style>
   .table tbody tr td{
            vertical-align: left;
         
        }
.table th, .table td { 
text-align: left;
vertical-align: left!important;
 
}
   
   </style>
	<form action="<%=path %>/jiaojuan" name="form1" method="post" class="form-horizontal" role="form">		
<table   class="table table-hover">
 <tr> <th class="text-left"> 测试题目 </th> </tr> </table>	
 		<table class="table table-hover table-striped table-bordered">
 			<c:if test="${fn:length(xuanzhe)>0}">
 		
 <c:forEach items="${requestScope.xuanzhe}"  varStatus="sta" var="timu">
 	<tr><td class="text-left">${sta.index+1 }：${timu.name }(本题${timu.fenshu }分)</td></tr>
	<tr ><td class="text-left">
		   A:<input type="radio" name="xz${sta.index }"  value="A" checked/>${timu.a}<br/>
		 B:<input type="radio" name="xz${sta.index }" value="B" />${timu.b}<br/>
	 C:<input type="radio" name="xz${sta.index }" value="C" />${timu.c}<br/>
D:<input type="radio" name="xz${sta.index }" value="D" />${timu.d}<br/>
<input name="xzdaan${sta.index }>" type="hidden"  value="${timu.daan}">			
<input type='hidden' name='xid${sta.index }' value='${timu.id}' />	
					</td>
				</tr>
	 <tr> <td colspan=6>
	 <a href="javascript:func(${sta.index })" style="color:red">点击查看解析</a></td> </tr> 	
	<tr> <td colspan=6>
	<table id=${sta.index }b style="display:none" >
<tr bgcolor="#E8FFE8"> 
<td >${timu.jiexi}</td>
</tr></table>
 </td> </tr> 	
			
			<br/>
			</c:forEach>
		</c:if>
			<c:if test="${fn:length(xuanzhe)==0}">
			       <tr><td> 没有题目</td></tr>
		</c:if>
			</table>
			

		
<table   class="table table-hover">
			    <tr>
			        <td>
			            <input type="hidden" name="kid" value="${param.id}"/>
 <button type="submit" class="btn  btn-primary" >提交测试</button>
			            
			        </td>
			    </tr>
			</table>
			<br/><br/>
		</form>
	
		
		
		
	</body>
</html>
