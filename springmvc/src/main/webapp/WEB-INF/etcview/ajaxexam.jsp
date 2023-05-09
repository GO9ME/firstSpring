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
     $("#testjsonbtn").on("click", function() {
      var queryData = {
        "deptno" : $("#deptno").val()
      };
      $.ajax({
        url : "/springmvc/ajax/getJsonData",
        type : "get",
        data : queryData,
        success : function(data) {  //data는 JSON Object
          // alert(data.deptno + "," + data.deptname)
          // 원하는 위치에 json데이터를 출력
          $("#deptno1").text(data.deptname);
          $("#deptname").text(data.deptname);
          $("#upperdept").text(data.deptuppercode);
          $("#jobcategory").text(data.job_category);
        },
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
</head>
<body>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<form>
					부서번호:<input type="text" name="deptno" id="deptno" /> <input
						type="button" value="ajax테스트" id="testbtn" /> <input
						type="button" value="ajaxjson테스트" id="testjsonbtn" />
				</form>
				<div id="result">
					<h4>
						부서번호: <span id="deptno1"></span>
					</h4>
					<h4>
						부서명:<span id="deptname"></span>
					</h4>
					<h4>
						상위부서:<span id="upperdept"></span>
					</h4>
					<h4>
						jobCategory:<span id="jobcategory"></span>
					</h4>
				</div>
			</div>
		</div>
	</div>
</body>
</html>