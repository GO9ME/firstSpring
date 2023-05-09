<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<h3>
					<a href="/springmvc/json/getString">스트링데이터받기</a>
				</h3>
				<h3>
					<a href="/springmvc/json/getJsonObj">DTO를 json으로 변환해서 받기</a>
				</h3>
				<h3>
					<a href="/springmvc/json/getJsonArr">ArrayList에 저장된 DTO를 json으로 변환해서
						받기</a>
				</h3>
				<h3>
					<a href="/erp/json/index">index페이지로 돌아가기</a>
				</h3>
			</div>
		</div>
	</div>
</body>
</html>