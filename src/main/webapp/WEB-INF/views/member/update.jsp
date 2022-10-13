<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/front.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src="${pageContext.request.contextPath }/resources/images/main_img.jpg"
 width="971" height="282"></div>
 
 
<form action="/member/updatePro" method="post" >
	<fieldset>
		<legend>회원정보</legend>
		아이디 : ${vo.userid } <br>
		비밀번호 : <input type="password" name="userpw" value="${vo.userpw }"> <br>
		이름 : ${vo.username } <br>
		이메일 : ${vo.useremail } <br>
		가입일 : ${vo.regdate } <br>
		
	</fieldset>
	<input type="submit" id="submit" value="수정">
</form>
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>