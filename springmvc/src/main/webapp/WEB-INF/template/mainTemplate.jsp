<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- top 영역 -->
	<tiles:insertAttribute name="top" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<!-- 왼쪽 sub메뉴 -->
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="col-lg-10">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
				<!-- 실제작업할때마다 교체될 작업페이지 -->
			</div>
		</div>
	</div>

</body>
</html>
