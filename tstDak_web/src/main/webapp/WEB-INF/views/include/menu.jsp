<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<div style="text-align: center;">
<b>PATH : "${path}"</b>
    <a href="${path}/">home</a>
    <a href="${path}/user/list.do">사용자목록</a>
</div>
<hr>
