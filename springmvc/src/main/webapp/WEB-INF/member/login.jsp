<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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

				<form name="login_frm" action="/springmvc/login.do" method="post">
					<table cellpadding="0" cellspacing=5 width="815" bgcolor=#f3f3f3
						border=0>
						<tr>
							<td bgcolor=#ffffff height=100% align=center valign=top>
								<table cellpadding=0 cellspacing=0 border=0 width=710>


									<tr>
										<td><a href=#>
												<table cellpadding="0" cellspacing=0 width="100%"
													bgcolor=#f7f7f7 border=0>
													<tr>
														<td bgcolor=#ffffff align=center>

															<table cellpadding="0" cellspacing="0" border=0
																align=center width=678>
																<tr>
																	<td align=center width=353>

																		<table cellpadding="0" cellspacing="0" border=0
																			width=353>
																			<tr>
																				<td><a href=#>
																						<table cellpadding="0" cellspacing="0" border=0>

																							<tr>
																								<td colspan=3><img
																									src="images/page_login.gif"></a></td>
																							</tr>
																							<tr>
																								<td height=25></a></td>
																							</tr>
																							<tr>
																								<td background="images/inputBg.gif"><img
																									src="images/login_id.gif"></a></td>
																								<td background="images/inputBg.gif"><input
																									type="text" name="id" size="15"
																									class="grayinput" tabindex=1
																									style="width: 156;" value=""></a></td>
																								<td rowspan=3 style="padding-left: 10"
																									valign=bottom><input type='image'
																									src="images/btn_login.gif" border="0"
																									tabindex=3></a></td>
																							</tr>
																							<tr>
																								<td height=10></a></td>
																							</tr>
																							<tr>
																								<td background="images/inputBg.gif"><img
																									src="images/login_pass.gif"></a></td>
																								<td background="images/inputBg.gif"><input
																									type="password" name="pass" size="15"
																									class="grayinput" tabindex='2'
																									style='width: 156;'> </a></td>
																							</tr>
																							<tr>
																								<td colspan=3 align=right
																									style="padding-right: 9; padding-top: 12"><span
																									style="display: inline"><label
																										for="member_id_save"><input
																											type="checkbox" name="member_id_save"
																											id="member_id_save" value="T" />아이디저장</label> </span></a></td>
																							</tr>
																						</table>
																				</a></td>
																			</tr>
																			<tr>
																				<td colspan=3></a></td>
																			</tr>

																		</table> </a>
																	</td>

																	<td style="padding-left: 60; padding-top: 60"></a></td>
																</tr>
																<tr>
																	<td colspan=3 style="padding-top: 20"
																		style=padding-left:40></a></td>
																</tr>
															</table> </a>
														</td>
													</tr>
												</table>
										</a></td>
									</tr>


									<tr>
										<td height=30></a></td>
									</tr>
									<tr>
										<td><a href=#></a></td>
									</tr>

									<tr>
										<td height=49></a></td>
									</tr>
								</table> </a>
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>

</body>
</html>