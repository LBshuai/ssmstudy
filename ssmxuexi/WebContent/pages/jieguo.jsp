<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<jsp:include flush="true" page="/pages/header.jsp"></jsp:include>
   <div style="width:950px;margin:0 auto">
<table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">           
${msg}
 &nbsp; &nbsp;</th></tr></table>
 
 
 <table class="table table-hover table-striped table-bordered">
 <tr><th class="text-center">           
 &nbsp; &nbsp;</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>

</div>
<jsp:include flush="true" page="/pages/footer.jsp"></jsp:include>