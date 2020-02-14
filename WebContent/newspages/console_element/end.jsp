<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/**
		*阻止浏览器缓存"Expires"和"Cache-Control"为应用程序服务器提供了一个控制浏览器和代理服务器上缓存的机制、
		*no-cache强制缓存从服务器上获取新的页面
		no-store在任何环境下缓存不保存任何页面
		**/
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		if(request.getSession().getAttribute("name")==null){
			%>
			<script type="text/javascript">
			alert("非法用户");
			location.href="../util/viewServletTopic";
			</script>
			<% 
		}
	%>
</body>
</html>