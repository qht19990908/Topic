<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function check(){
	var tname=document.getElementByName("tnam");
	if(tname.value=""){
		alert("新闻主题不能为空,请重新输入！");
		tname.focus();
		return false;
	}
	return true;
}
</script> 
</head>
<body>
<%@include file="console_element/end.jsp" %>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改： </h1>
    <form action="../util/UpdateServletTopic" method="post" onsubmit="return check()">
    <%
    String tnam=new String(request.getParameter("tnam").getBytes("ISO-8859-1"),"utf-8");
    String id=new String(request.getParameter("tid").getBytes("ISO-8859-1"),"utf-8");
    int tid=Integer.parseInt(id);
    %>
      <p>
        <label> 主题 </label>
        <input name="tnam" type="text" class="opt_input" id="tname" value="<%=tnam%>"/>
      </p>
      <input name="tid" type="hidden" value="<%=tid%>"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
