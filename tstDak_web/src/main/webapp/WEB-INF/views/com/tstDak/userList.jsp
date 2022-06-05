<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>
<%@ include file="../../include/header.jsp" %>
</head>
<body>
<%@ include file="../../include/menu.jsp" %>
<h2>회원목록</h2>
<input type="button" value="회원등록" onclick="location.href='${path}/user/register.do'">
<table border="1" width="700px">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>나라</th>
    </tr>
    <c:forEach var="item" items="${list}"> 
    <tr>
        <td>${item.id}</td>
        <td>
        <a href="${path}/user/view.do?userid=${item.id}">${item.name}</a>
        </td>
        <td>${item.email}</td>
        <td>${item.country}</td>
        <!-- <td><fmt:formatDate value="${item.join_date}" pattern="yyyy-MM-dd HH:mm:ss" /> </td> -->
    </tr>
    </c:forEach>    
</table>
</body>
</html>
