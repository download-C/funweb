<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


String DRIVER = "com.mysql.cj.jdbc.Driver";
String DBURL = "jdbc:mysql://localhost:3306/jspdb";
String DBID = "root";
String DBPW = "1234";

Class.forName(DRIVER);
Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);

// 3. sql 작성 및 stmt 객체 생성
String sql = "select * from itwill_member where id = '"+id+"' and pw = '"+pw+"'";
Statement stmt = con.createStatement();
// 4. sql 실행
ResultSet rs = stmt.executeQuery(sql);

if(rs.next()) {
	// 아이디, 비밀번호 일치
		// 아이디로 세션값 생성 후 메인 페이지로 이동
	session.setAttribute("id", id);
	response.sendRedirect("../main/main.jsp");
} else {
	// 아이디, 비밀번호 불일치
	%>
	<script type="text/javascript">
		alert('아이디 비밀번호 틀림');
		history.back();
	</script>
	<%
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> loginPro2.jsp</h1>
</body>
</html>