<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 공유된 데이터 꺼내기. 꺼낸건 Object 이므로 String으로 캐스킹해야됨.
	String name = (String) request.getAttribute("insertUser");
	
	%>

	<h1>자바나라쇼핑몰</h1>
	<hr />
	<h2><%= name %>님의 가입 환영합니다.</h2>
</body>
</html>