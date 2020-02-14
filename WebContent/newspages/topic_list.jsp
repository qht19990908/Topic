<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@include file="console_element/end.jsp" %>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist">
     <c:forEach items="${list}" var="topics">
      <li> &#160;&#160;&#160;&#160; ${topics.tnam} &#160;&#160;&#160;&#160; <a href="../newspages/topic_update.jsp?tid=${topics.tid}&tnam=${topics.tnam}">修改</a> &#160;&#160;&#160;&#160; <a href='../util/DelServletTopic?tid=${ topics.tid}'>删除</a> </li>
    </c:forEach>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
