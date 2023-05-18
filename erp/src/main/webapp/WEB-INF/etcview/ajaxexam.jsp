<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		//id가 testbtn인 버튼을 눌렀을 때 /erp/ajax/exam01을 요청
		$("#testbtn").on("click", function() {
			var querydata = {
				"boardno" : $("#boardno").val()
			}
			$.ajax({
				url : "/erp/ajax/exam01",
				type : "get",
				data : querydata,
				dataType : "json",
				success : function(items) {
					console.log(items);
					$("#no").text(items.board_no);
					$("#title").text(items.title);
					$("#writer").text(items.id);
					$("#content").text(items.content);
				},
				error : error_run
			})
		})

		//id가 testjsonbtn인 버튼을 눌렀을 떄 /erpajax/exma02/getjsondata
		$("#testjsonbtn").on("click", function() {

			$.ajax({
				url : "/erp/ajax/exam02/getjsondata",
				type : "get",
				dataType : "json",
				success : function(data) {

					const result = document.createElement('div')
					$.each(data, function(index, item) {
						result.appendChild(make_list('h4', item.board_no));
						result.appendChild(make_list('h4', item.title));
						result.appendChild(make_list('h4', item.id));
						result.appendChild(make_list('h4', item.content));
						result.appendChild(document.createElement('hr'))
					});
					$('#printarr').append(result);

				},
				error : error_run
			})
		})
	})

	function make_list(element, item) {
		const board_no = document.createElement(element);
		let text = document.createTextNode(item);
		board_no.appendChild(text);
		return board_no;
	}

	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
</head>
<body>
	<form>
		글번호:<input type="text" name="boardno" id="boardno" /> <input
			type="button" value="ajax테스트" id="testbtn" /> <input type="button"
			value="ajaxjson테스트" id="testjsonbtn" />
	</form>
	<div id="result">
		<h4>
			글번호:<span id="no"></span>
		</h4>
		<h4>
			제목:<span id="title"></span>
		</h4>
		<h4>
			작성자:<span id="writer"></span>
		</h4>
		<h4>
			내용:<span id="content"></span>
		</h4>
	</div>
	<div id="printarr"></div>
</body>
</html>