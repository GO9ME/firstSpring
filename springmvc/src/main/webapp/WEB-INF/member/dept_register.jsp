<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../main/top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="../layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<div class="container-fluid">
					<a href="/serverweb/mvc/list.do">
						<h1>회원목록보기</h1>
					</a>
					<form role="form" class="form-horizontal"
						action="/springmvc/mvc/insert.do" method="POST" name="myform">
						<fieldset>
							<div id="legend">
								<legend>아래 양식을 작성해주세요.</legend>
							</div>
							<div class="form-group">
								<div class="col-md-2 text-right">
									<label for="files" class="control-label">파일1</label>
								</div>
								<div class="col-md-8">
									<input type="file" class="form-control input-lg" name="files"
										id="files" placeholder="파일선택" multiple="multiple">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2 text-right">
									<label for="title" class="control-label">파일2</label>
								</div>
								<div class="col-md-8">
									<input type="file" class="form-control input-lg" name="files"
										id="title" placeholder="파일선택">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2 text-right">
									<label for="files" class="control-label">파일3</label>
								</div>
								<div class="col-md-8">
									<input type="file" class="form-control input-lg" name="files"
										id="files" placeholder="파일선택">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2 text-right">
									<label for="files" class="control-label">파일4</label>
								</div>
								<div class="col-md-8">
									<input type="file" class="form-control input-lg" name="files"
										id="files" placeholder="파일선택">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2 text-right">
									<label for="title" class="control-label">파일5</label>
								</div>
								<div class="col-md-8">
									<input type="file" class="form-control input-lg" name="files"
										id="title" placeholder="파일선택">
								</div>
							</div>


							<div class="form-group">
								<!-- Button -->
								<div class="col-sm-3 col-sm-offset-2">
									<input type="submit" value="가입하기" class="btn btn-success" />
								</div>
							</div>
						</fieldset>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>