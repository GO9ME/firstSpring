<%@page import="kr.multi.erp.member.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<EmpDTO> userList = (ArrayList) request.getAttribute("userList"); %>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<h1>회원목록조회</h1>
				<table border="1">
					<tr>
						<th>부서코드</th>
						<th>성명</th>
						<th>아이디</th>
						<th>주소</th>
						<th>포인트</th>
						<th>등급</th>
						<th>삭제</th>
					</tr>
					<% 
					for (EmpDTO user : userList) {
					%>
					<tr>
						<td><%=user.getDeptno()%></td>
						<td><%=user.getName()%></td>
						<td><a href="/springmvc/emp/read.do?id=<%= user.getId() %>&state=READ"><%= user.getId() %></a></td>
						<td><%=user.getAddr()%></td>
						<td><%=user.getPoint()%></td>
						<td><%=user.getGrade()%></td>
						<td><a
							href='/springmvc/emp/delete.do?test=info&id=<%= user.getId() %>'>삭제</a></td>
					</tr>
					<% } %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>