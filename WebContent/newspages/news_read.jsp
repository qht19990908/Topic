<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.qhit.entity.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<%
String path=request.getContextPath();
%>
<link href="<%=path%>/css/read.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<div id="top_login">
			<label> 登录名 </label> <input type="text" id="uname" value=""
				class="login_input" /> <label> 密&#160;&#160;码 </label> <input
				type="password" id="upwd" value="" class="login_input" /> <input
				type="button" class="login_sub" value="登录" onclick="login()" /> <label
				id="error"> </label> <a href="../index1.jsp" class="login_link">返回首页</a>
			<img src="../images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		<div id="nav">
			<div id="logo">
				<img src="../images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="../images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container" style="height: 880px">
	<%@ include file="../index-elements/index_sidebar.jsp"%>
		<div class="main" style="overflow-y: auto; height: 80%">
			<div class="class_type">
				<img src="../images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<%
            request.getAttribute("n");
            %>
				<%
        request.getAttribute("list");
        %>
				<ul class="classlist">
					<table width="80%" align="center">
						<tr width="100%">
							<td colspan="2" align="center">${n.ntitle }</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">2009-10-28 01:03:51.0</td>
							<td align="left">sport</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
						<tr>
						
							<td colspan="2">${n.ncontent}<hr />
					
							</td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<table width="80%" align="center">
					<c:forEach items="${list }" var="list">
						<tr>
							<td colspan="6">评论内容：${list.ccontent}&nbsp;&nbsp;&nbsp;&nbsp;用户名：${list.cauthor }&nbsp;&nbsp;&nbsp;&nbsp;创建时间：${list.cdate}</td>
						</tr>
								</c:forEach>
						<tr>
							<td colspan="6"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<form action="../util/AddServletComments?nid=${n.nid}"
						method="post">
						<table width="80%" align="center">
							<tr>
								<td>评 论</td>
							</tr>
							<tr>
								<td>用户名：</td>
								<td><input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" />
									IP： <input name="cip" value="127.0.0.1" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="ccontent" cols="70"
										rows="10"></textarea></td>
							</tr>
							<td><input name="submit" value="发  表" type="submit" /></td>
						</table>
					</form>
				</ul>
			</div>
		</div>
	</div>
	<%@include file="../index-elements/index_bottom.html"%>
</body>
</html>
