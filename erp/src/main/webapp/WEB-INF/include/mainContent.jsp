<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/erp/common/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#boardCategory>li")
								.each(
										function() {
											$(this)
													.click(
															function() {
																$(
																		"#boardCategory>li")
																		.removeClass(
																				'active');
																$(this)
																		.addClass(
																				"active");
																category = $(
																		this)
																		.text();
																$
																		.ajax({
																			url : "/erp/board/ajax/list.do",
																			type : "get",
																			data : {
																				"category" : category
																			},
																			success : function(
																					data) {
																				/* 	<tr>
																						<td class="boardContent" style=""><a
									href="/erp/board/read.do/${board.board_no}/read">${board.title }</a></td>
																						<td class="boardDate" style="">${board.write_date}</td>
																					</tr> */
																				printdata = "";
																				for (var i = 0; i < data.length; i++) {
																					printdata += '<tr><td class="boardContent" style=""><a href="/erp/board/read.do/'+data[i].board_no+'/read">'
																							+ data[i].title
																							+ '</a></td><td class="boardDate" style="">'
																							+ data[i].write_date
																							+ '</td></tr>';

																				}
																				$(
																						"#mydatalist")
																						.empty();
																				console
																						.log(printdata);
																				$(
																						"#mydatalist")
																						.append(
																								printdata);
																			},
																			error : error_run

																		})

															})

										})
					})
	function error_run(obj, msg, statusMsg) {
		alert("오류발생 === > " + obj + "," + msg + "," + statusMsg);
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					style="width: 600px; height: 300px">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="/erp/images/multi1.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

						<div class="item">
							<img src="/erp/images/multi2.jpg" alt="Image"
								style="width: 800px; height: 300px">

						</div>
						<div class="item">
							<img src="/erp/images/multi3.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>


					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px; width: 450px">
					<div class="panel-footer">사내소식</div>
					<div class="panel-body">
						<ul class="nav nav-tabs" id="boardCategory">
							<li class="active"><a href="#">게시판</a></li>
							<li><a href="#">사내소식</a></li>
							<li><a href="#">경조사</a></li>
						</ul>
						<div id="boardMain" style="padding-top: 20px; padding-left: 10px">
							<table id="mydatalist">
								<c:forEach var="board" items="${boardlist}">
									<tr>
										<td class="boardContent" style=""><a
											href="/erp/board/read.do/${board.board_no}/read">${board.title }</a></td>
										<td class="boardDate" style="">${board.write_date}</td>
									</tr>
								</c:forEach>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="row main-row">
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">News</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>