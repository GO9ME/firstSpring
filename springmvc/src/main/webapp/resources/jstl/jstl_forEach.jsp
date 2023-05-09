<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1부터 10까지 출력</h2>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="mystatus">
		<h2>${i },current=>${mystatus.current},index=>${mystatus.index},first=>${mystatus.first},
			last=>${mystatus.last},begin=>${mystatus.begin}, end=>${mystatus.end},step=>${mystatus.step}
		</h2>
	</c:forEach>
</body>
<script type="text/javascript">

</script>
</html>