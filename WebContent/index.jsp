<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="header">
		<div id="top_login">
			<form action="../util/loginServlet" method="post">
				<label> 登录名 </label> <input type="text" name="uname" id="uname"
					value="" class="login_input" /> <label> 密&#160;&#160;码 </label> <input
					type="password" name="upwd" id="upwd" value="" class="login_input" />
				<input type="submit" class="login_sub" value="登录" /> <label
					id="error"> </label> <img
					src="${pageContext.request.contextPath}/images/friend_logo.gif"
					alt="Google" id="friend_logo" />
			</form>
		</div>
		<div id="nav">
			<div id="logo">
				<img src="${pageContext.request.contextPath}/images/logo.jpg"
					alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="${pageContext.request.contextPath}/images/a_b01.gif"
					alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">
		<%@ include file="index-elements/index_sidebar.jsp"%>
		<div class="main">
			<div class="class_type">
				<img src="${pageContext.request.contextPath}/images/class_type.gif"
					alt="新闻中心" />
			</div>
			<div class="content">

				<ul class="class_date">
					<li id='class_month'><c:forEach items="${list}" var="topics">
							<a href="../util/nameServletTopic?tid=${topics.tid }"><b>
									${topics.tnam} </b></a>
						</c:forEach></li>
				</ul>



				<ul class="classlist">
					<c:forEach items="${page.newsList}" var="topics" varStatus="page">
						<li><a href='../util/readServletComments?nid=${topics.nid }'>${topics.ntitle }
						</a><span> ${topics.ncreateDate } </span></li>
						</li>
						<c:if test="${page.count % 5 == 0}">
							<li class='space'></li>
						</c:if>
					</c:forEach>
					<p align="right">
						当前页数:[${page.currPageNo}/${page.totalPageCount }]&nbsp; <a
							href="../util/viewServletTopic?currPageNo=${page.currPageNo-1 }">上一页</a><a
							href="../util/viewServletTopic?currPageNo=${page.currPageNo+1 }">下一页</a>
						<a
							href="../util/viewServletTopic?currPageNo=${page.totalPageCount }">末页</a>
					</p>
				</ul>
			</div>
			<%@ include file="index-elements/index_rightbar.jsp"%>
		</div>
	</div>
	<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
