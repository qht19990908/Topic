<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.qhit.entity.*"%>
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
	<%@include file="console_element/top.jsp"%>
	<div id="main">
		<%@include file="console_element/left.html"%>
		<div id="opt_area">
			<h1 id="opt_type">修改新闻：</h1>
			<form action="../util/UpdateServletNews" method="post" enctype="multipart/form-data">
				<%
					News n = (News) request.getAttribute("news");
				%>
				<%
					List<Topic> list = (List) request.getAttribute("list");
				%>
				<p>
					<label> 主题名称 </label> <select name="ntid">
						<%
							for (Topic top : list) {
								if (top.getTid() == n.getNtid()) {
						%>
						<option value="<%=top.getTid()%>" selected="selected"><%=top.getTnam()%>
						</option>
						<%
							} else {
						%>
						<option value="<%=top.getTid()%>"><%=top.getTnam()%>
						</option>
				</p>
				<%
					}
					}
				%>
				</select>
				 <input name="nid" type="hidden" value="<%=n.getNid()%>"/>
				<p>
					<label> 标题 </label> <input name="ntitle" type="text"
						class="opt_input" value="<%=n.getNtitle()%>" />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" type="text"
						class="opt_input" value="<%=n.getNauthor()%>" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3"><%=n.getNsummary()%></textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10"><%=n.getNcontent()%></textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="file" type="file"
						class="opt_input" />
				</p>
				<input name="action" type="hidden" value="addnews" /> <input
					type="submit" value="提交" class="opt_sub" /> <input type="reset"
					value="重置" class="opt_sub" />
			</form>
			<h1 id="opt_type">修改新闻评论：</h1>
			<table width="80%" align="left">
			<c:forEach items="${comments}" var="c">
				<tr>
					<td colspan="6">评论内容：${c.ccontent }</td>
				</tr>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td>留言人：</td>
					<td>${c.cauthor }</td>
					<td>IP：</td>
					<td>${c.cip }</td>
					<td>留言时间：</td>
					<td>${c.cdate }</td>
					<td><a href="../util/DelServletComments?cid=${c.cid}&nid=<%=n.getNid()%>">删除</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">
		<%@include file="console_element/bottom.html"%>
	</div>
</body>
</html>
