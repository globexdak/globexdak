<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보</title>
<%@ include file="../../include/header.jsp" %>
</head>
<body>
<%@ include file="../../include/menu.jsp" %>
<h2>회원정보</h2>
<input type="button" value="회원탈퇴" onclick="location.href='${path}/user/delete.do?userid=${item.id}&passwd=${item.passwd}'">
<input type="button" value="회원정보수정" onclick="location.href='${path}/user/modify.do?userid=${item.id}'">

<table border="1" width="700px">

    <tr>
        <td>아이디</td>
        <td>${item.id}</td>
    </tr>
    <tr>
        <td>암호</td>
        <td>${item.passwd}</td>
    </tr>
    <tr>
        <td>이름</td>
        <td>${item.name}</td>
    </tr>
    <tr>
        <td>이메일</td>
        <td>${item.email}</td>
    </tr>
    <tr>
        <td>국가</td>
        <td>${item.country}</td>
    </tr>
    
</table>
<br><br>
<div align="center">
	<input type="button" value="처음화면" onclick="location.href='${path}/'" />
</div>
</body>
</html>
