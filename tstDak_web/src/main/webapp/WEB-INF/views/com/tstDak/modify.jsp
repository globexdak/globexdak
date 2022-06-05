<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<%@ include file="../../include/header.jsp"%>
</head>
<body>
<%@ include file="../../include/menu.jsp"%>
<h2>회원정보수정</h2>

	<form name="registerForm" action="${path}/user/update.do" method="post">
		<br>
		<br>
		<h1>회원정보수정</h1>
		<br>
		<br>
		<b>
		<c:if test="${message != null}">메시지 => ${message}</c:if>
		</b>
		<table border="1" width="700px">

			<tr>
				<td>아이디</td>
				<td>${item.id}
					<input type="hidden" name="id" id="id" value="${item.id}">
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="text" size="40" name="passwd" id="passwd"
					value="${item.passwd}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" size="40" name="name" id="name"
					value="${item.name}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" size="40" name="email" id="email"
					value="${item.email}"></td>
			</tr>
			<tr>
				<td>국가</td>
				<td><input type="text" size="40" name="country" id="country"
					value="${item.country}"></td>
			</tr>

		</table>
		<br>
		<br>
		<div align="center">
			<input type="button" value="처음화면" onclick="location.href='${path}/'" />
			<input type="submit" value="수정">
		</div>
	</form>
</body>
</html>
