<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="sidebar">
	<h1>
		<img src="${pageContext.request.contextPath}/images/title_1.gif" alt="国内新闻" />
	</h1>
	<div class="side_list">
		<ul>
			<c:forEach items="${list9}" var="list1" varStatus="i">
				<li><a href='../util/readServletComments?nid=${list1.nid }'><b>
							${list1.ntitle} </b></a></li>
			</c:forEach>
		</ul>
	</div>
	<h1>
		<img src="${pageContext.request.contextPath}/images/title_2.gif" alt="国际新闻" />
	</h1>
	<div class="side_list">
		<ul>
			<c:forEach items="${list8}" var="list2" varStatus="i">
				<li><a href='../util/readServletComments?nid=${list2.nid }'><b>
							${list2.ntitle} </b></a></li>
			</c:forEach>
		</ul>
	</div>
	<h1>
		<img src="${pageContext.request.contextPath}/images/title_3.gif" alt="娱乐新闻" />
	</h1>
	<div class="side_list">
		<ul>
			<c:forEach items="${list7}" var="list3" varStatus="i">
				<li><a href='../util/readServletComments?nid=${list3.nid }'><b>
							${list3.ntitle} </b></a></li>
			</c:forEach>
		</ul>
	</div>
</div>
<%--
	request.removeAttribute("news_in_topic");
--%>
