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
      //alert("test");
      location.href = "/springmvc/ajax/noajax?id=" + $("#id1").val()
    })
     $("#ajaxbtn").on("click", function() {
      //ajax로 요청
      var queryData = {
        "id" : $("#id1").val()
      };
      $.ajax({
        url : "/springmvc/ajax/ajaxtest01",
        type : "get",
        data : queryData,
        success : success_run,
        error : error_run
      });// end ajax
    }); //end click
  }); //end ready
 
  //ajax요청을 성공하면 .ajax메소드 내부에서 success속성에 설정한 함수를 호출하면서 ajax처리 결과를 자동으로 함수의 매개변수로 전달
  function success_run(txt) {
    // alert("테스트");
    $("#result").html("<h2>jQuery:" + txt + "</h2>");
  }
  //obj - ajax통신을 하는 객체, msg - 응답 메시지, statusmsg - 에러
  function error_run(obj, msg, statusmsg) {
    alert("오류메시지 => " + obj + "," + msg + "," + statusmsg);
  }
  
</script>
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
				<h3>Ajax테스트하기</h3>
				<form name="myform">
					<input type="text" name="id" id="id1" /> <input type="text"
						name="name" id="name" /> <input type="button" id="noajaxbtn"
						value="no ajax테스트"> <input type="button" id="ajaxbtn"
						value="ajax테스트">
				</form>
				<div id="result">${ msg }</div>

				<h3>Ajax테스트하기(JQuery...get)</h3>
				<form name="myform">
					<input type="text" name="id" id="id2" /> <input type="button"
						id="ajaxbtn2" value="ajax테스트">
				</form>
				<div id="result2"></div>


				<h3>Ajax테스트하기(JQuery...post)</h3>
				<form name="myform">
					<input type="text" name="id" id="id3" /> <input type="button"
						id="ajaxbtn3" value="ajax테스트">
				</form>
				<div id="result3"></div>
			</div>
		</div>
	</div>
</body>
</html>