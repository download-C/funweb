<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<%
	if(session.getAttribute("loginID") == null){
%>
	<div id="login"><a href="${pageContext.request.contextPath }/member/login">login</a> | <a href="${pageContext.request.contextPath }/member/join">join</a></div>
	<div class="clear"></div>
<%
} else {
%>
	<div id="login">
	<a href="${pageContext.request.contextPath }/member/logout">logout</a>
	<a href="${pageContext.request.contextPath }/member/update">update</a>
	<a href="${pageContext.request.contextPath }/member/list">list</a>
	</div>
	<div class="clear"></div>
<%} %>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src="${pageContext.request.contextPath }/resources/images/logo.gif" width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href="${pageContext.request.contextPath }/main/main">HOME</a></li>
	<li><a href="${pageContext.request.contextPath }/company/welcome">COMPANY</a></li>
	<li><a href="#">SOLUTIONS</a></li>
	<li><a href="${pageContext.request.contextPath }/center/notice">CUSTOMER CENTER</a></li>
	<li><a href="#">CONTACT US</a></li>
</ul>			

</nav>
</header>
</body>
</html>