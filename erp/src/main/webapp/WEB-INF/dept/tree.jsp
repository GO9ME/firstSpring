<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/erp/common/css/jquery.treeview.css" />
<link rel="stylesheet" href="/erp/common/css/screen.css" />

<script src="/erp/common/js/jquery.cookie.js"></script>
<script src="/erp/common/js/jquery.treeview.js"></script>
<script src="/erp/common/js/demo.js"></script>

<script type="text/javascript">
	$(function() {
		// 리스트 쭉 가져오기
		$(".folder").on("click", function() {
			var ulnode = $(this).next();
			var deptno = ulnode.attr("id");
			ulnode.empty();
			$.ajax({
				url : "/erp/emp/ajaxtreedata",
				type : "get",
				data : {
					"deptno" : deptno
				},
				success : function(resultdata) {
					const result = JSON.parse(resultdata);

					for (i in result.deptlist) {
						var li = $('<li class="closed"></li>');
						var span = $('<span class="folder"></span>');
						var ul = $("<ul></ul>");
						// Set the text content of the LI element
						span.text(result.deptlist[i].deptname);
						ul.attr('id', result.deptlist[i].deptno);
						li.append(span);
						li.append(ul);

						// Append the LI element to the UL element
						ulnode.append(li);
					}
					for (i in result.memberlist) {
						var li = $('<li></li>');
						var span = $('<span class="file"></span>');

						span.text(result.memberlist[i].name);
						li.append(span);
						ulnode.append(li);
					}
					//동적으로 생성된 엘리먼트에 이벤트 연결하기
					//$(document).on("이벤트명",이벤트를 연결하기 위한 )
					$(document).on("click", ".folder", function() {
						var subulnode = $(this).next();
						var subdeptno = subulnode.attr('id');
						console.log(subdeptno);
						// ajax 요청해서 부서에 근무하는 직원이나 서브부서 정보 받아오기
						//-> 동일한 컨트롤러로 작업할 수 있음, 이작업을 하기 위해서는 deplist 나 memberlist의 값체크해서 작업하기

					})
				},
				error : error_run

			})
		})
	});

	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
</head>
<body>
	<div id="main">
		<h4>조직도</h4>
		<ul id="browser" class="filetree">
			<c:forEach var="dept" items="${deptlist }">
				<c:if test="${dept.deptlevel==1 }">
					<li class="closed"><span class="folder">${dept.deptname}</span>
						<ul id="${dept.deptno }" class="filetree">
							<!-- <li><span class="file">Item 1.1</span></li> -->
						</ul></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</body>
</html>