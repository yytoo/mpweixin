<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
/*  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  */
 String basePath ="https://85015021.qcloud.la"; 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
<script type="text/javascript" src="<%=basePath %>/<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>/<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="<%=basePath %>/<%=request.getContextPath()%>/js/myjs.js"></script>
  <%--   <script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/myjs.js"></script> --%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%=basePath%>
  <%=request.getContextPath()%>
	<table>
		<tbody>
		<tr>
		<th>类别</th>
		<td colspan="3" ><input type="text" id="typeId" value=""></td>
		</tr>
			<tr>
		    <th>上传图片</th>	    				
		    <td colspan="3">    
		    <input type="file" id="upload" name="upload" onchange="fileUpload('<%=basePath %>');">
		   </td>
		  </tr>
		</tbody>
	</table>
  </body>
</html>
