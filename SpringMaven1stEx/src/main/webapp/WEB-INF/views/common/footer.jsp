<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>하단부</title>
	
	<style>
		p {
			font-size: 20px;
			text-align: center;
		}
	</style>
</head>

<body>
	<p> e-mail : admin@test.com </p>
	<p> 회사주소 : 서울시 강동구 </p>
	<p> 찾아오시는 길 : <a href="#">약도</a> </p>
</body>

</html>