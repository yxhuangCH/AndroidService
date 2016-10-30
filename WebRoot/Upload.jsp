<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Upload</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  				<center>
  					<form
  							action="${pageContext.request.contextPath }/servlet/UploadImage"
  							 method="post"   enctype ="multipart/form-data">
  							<table>
  									<tr>
  											<td>
  														Name
  											</td>
  											<td>
  													<input type = "text"  name="Name">
  											</td>
  									</tr>
  									<tr>
  											<td>
  													Gender
  											</td>
  											<td>		
  														<input type="text"  name="Gender">
  											</td>
  									</tr>
  									<tr>
  											<td>
  													Select a picture to upload
  											</td>
  											<td>
  														<input type="file"  name="image">
  											</td>
  									</tr>
  									<tr>
  											<td >
  														<input type="submit"  value = "上传">
  											</td>
  											<td>
  														<input type="reset"  value="重置">
  											</td>
  									</tr>
  							</table>
  					</form>
  				</center>
  
  <body>
  
  </body>
</html>
