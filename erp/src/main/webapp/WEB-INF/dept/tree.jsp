<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/erp/common/css/jquery.treeview.css" />
<link rel="stylesheet" href="/erp/common/css/screen.css" />
<script src="/erp/common/js/jquery.cookie.js"></script>
<script src="/erp/common/js/jquery.treeview.js"></script>
<!-- <script src="/erp/common/js/demo.js"></script> -->

<script type="text/javascript">

	$(function() {
		// 리스트 쭉 가져오기
		$.ajax({
			url : "/erp/emp/selectTree",
			type : "get",
			dataType : "json",
			success : function(data) {
				console.log(data);
				// 필요한 데이터만 추출합니다.
				for (key in data) {
					console.log(data[key]);
				}
				$("#browser").treeview({
					data : data,
				    collapsed: true
				});
			},
			error : error_run

		}) // ajax selectCode

	}) //ready

	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
</head>
<body>
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
</body>
</html>