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


<script type="text/javascript">
	$(function() {
		// 리스트 쭉 가져오기
		$('#browser>li').click(function() {
			$.ajax({
				url : "/erp/emp/selectDeptname",
				type : "get",
				data : {
					"job_category" : $(this).find('div').attr('value')
				},
				success : function(data) {
					console.log(data);
				},

				error : error_run
			})
		})

	}) //ready

	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
</head>
<body>
<<<<<<< HEAD
	<h2>조직도</h2>
	<ul id="browser" class="filetree">
		
		<!-- 		 <li><span class="folder">Folder 1</span>
			<ul>
				<li><span class="file">Item 1.1</span></li>
			</ul></li>
		<li><span class="folder">Folder 2</span>
			<ul>
				<li><span class="folder">Subfolder 2.1</span>
					<ul id="folder21">
						<li><span class="file">File 2.1.1</span></li>
						<li><span class="file">File 2.1.2</span></li>
					</ul></li>
				<li><span class="file">File 2.2</span></li>
			</ul></li>
		<li class="closed"><span class="folder">Folder 3 (closed
				at start)</span>
			<ul>
				<li><span class="file">File 3.1</span></li>
			</ul></li>
		<li><span class="file">File 4</span></li>  -->
	</ul>
=======
	<h1 id="banner">
		<a href="http://bassistance.de/jquery-plugins/jquery-plugin-treeview/">jQuery
			Treeview Plugin</a> Demo
	</h1>
	<div id="main">
		<h4>조직도</h4>
		<ul id="browser" class="filetree">
		<c:forEach var="dept" items="${deptlist }">
			<c:if test="${dept.deptlevel==1 }">
				<li class="closed">
					<span class="folder">${dept.deptname}</span>
					<ul id="${dept.deptno }">
						<!-- <li><span class="file">Item 1.1</span></li> -->
					</ul>
				</li>
			</c:if>
		</c:forEach>
		</ul>
	</div>
>>>>>>> 0af8feecbf640dd0ef7bba820aacdf15b11e6193
</body>
</html>