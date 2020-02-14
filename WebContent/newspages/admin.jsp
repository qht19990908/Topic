<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<%
String path=request.getContextPath();
%>
<link href="<%=path%>/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/end.jsp" %>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist">
    <c:forEach items="${page.newsList}" var="news" varStatus="page">
	      <li>${news.ntitle }<span> 作者: ${news.nauthor } &#160;&#160;&#160;&#160; <a href='../util/preUpdateServletNews?nid=${news.nid }'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/DelServletNews?nid=${news.nid}' onclick='return clickdel()'>删除</a> </span> </li>
	<c:if test="${page.count % 5 == 0}"><li class='space'></li></c:if>
	</c:forEach>    
	      <li class='space'></li>
	      <p align="right">
						当前页数:[${page.currPageNo}/${page.totalPageCount }]&nbsp; <a href="../util/listServletNews?currPageNo=${page.currPageNo-1 }">上一页</a><a href="../util/listServletNews?currPageNo=${page.currPageNo+1 }">下一页</a> <a href="../util/listServletNews?currPageNo=${page.totalPageCount }">末页</a>
					</p>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
