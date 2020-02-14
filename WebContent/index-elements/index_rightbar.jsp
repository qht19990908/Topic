<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="picnews">
  <ul>
  <c:forEach items="${list6 }" var="list">
    <li> <a href="#"><img src="../upload/2019/1/${list.npicPath }" width="249" alt="" /> </a><a href="../util/readServletComments?nid=${list.nid }&ncontent=${list.ncontent}">${list.ntitle }</a> </li>
  <%--   <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">¹úÇì¶à±äµÄ·¢ÐÍ</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">ÐÂ¼¼ÊõÕÕÁÁ¶¼ÊÐ</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">ÈºÐÇÉÁÒ«ºìµØÌº</a> </li>
  --%></c:forEach></ul>
</div>
</body>
</html>