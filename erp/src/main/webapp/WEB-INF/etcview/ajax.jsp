<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#noajaxbtn").on("click", function() {
			location.href = "/erp/ajax/noajax?id=" + $("#id1").val()
		})
		$("#ajaxbtn").on("click", function() {
			var querydata = {
				"id" : $("#id1").val()
			}
			$.ajax({
				url : "/erp/ajax/ajaxtest01",
				type : 'GET',
				data : querydata,
				success : success_run,
				error : error_run
			})

		})
		$("#guguajaxbtn").on("click", function() {
			var querydata = {
				"dan" : $("#dan").val()
			}
			$.ajax({
				url : "/erp/ajax/gugu",
				type : 'GET',
				data : querydata,
				success : function gugudan(data) {

					$("#result2").html("<h2>" + data + "</h2>");

				},
				error : error_run
			})

		})
	})

	function success_run(data) {
		$("#result").html("<h2>jquery" + data + "</h2>");
	}
	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
<title>Insert title here</title>
</head>

<body>
	<h3>Ajax테스트하기</h3>
	<form name="myform">
		<input type="text" name="id" id="id1" /> <input type="text"
			name="name" id="name" /> <input type="button" id="noajaxbtn"
			value="no aajx테스트"> <input type="button" id="ajaxbtn"
			value="ajax테스트">
	</form>
	<div id="result">${msg }</div>

	<h3>구구단 출력하기</h3>
	<form name="myform">
		<input type="text" name="id" id="dan" /> <input type="button"
			id="guguajaxbtn" value="구구단출력">
	</form>
	<div id="result2"></div>


	<h3>Ajax테스트하기(JQuery...post)</h3>
	<form name="myform">
		<input type="text" name="id" id="id3" /> <input type="button"
			id="ajaxbtn3" value="ajax테스트">
	</form>
	<div id="result3"></div>
</body>
</html>