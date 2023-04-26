<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링이 공유해준 데이터</h1>
	<hr/>
	<h2>EL로 출력(공유명을 정의) : ${msg}</h2>
	<h3>EL 공유명을 명시하면 page scope에서 공유명으로 공유된 데이터를 찾는다.
		없으면 request scope에서 또 없으면 session scope에서 application scope에서 찾는다.
		없으면 출력하지 않는다. ( null & exception에 관대 )
	</h3>
	
	
</body>
</html>