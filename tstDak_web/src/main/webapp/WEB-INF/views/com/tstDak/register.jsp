<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>회원등록</title>
<%@ include file="../../include/header.jsp" %>
</head>
<body>
<%@ include file="../../include/menu.jsp" %>
	<form name="registerForm" action="${path}/user/insert.do" method="post">
		<br><br>
		<h1>회원등록</h1>
		<br><br>
		<table border="1" align="center" width="30%">
			<tr>
				<th>ID</th>
				<td><input type="text" size="40" maxlength="10" name="id" id="id" ></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" size="40" name="passwd" id="passwd" ></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" size="40" name="name" id="name" ></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" size="40" name="email" id="email" ></td>
			</tr>
			<tr>
				<th>국가</th>
				<td><input type="text" size="40" name="country" id="country" ></td>
			</tr>
		</table>
		<br><br>
		<div align="center">
			<input type="button" value="처음화면" onclick="location.href='${path}/'" />
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>