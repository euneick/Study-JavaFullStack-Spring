<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>상단부</title>
</head>

<body>
	<table width="100%">
		<tr>
			<td>
				<a href="${ contextPath }/main.do">
					<img src="${ contextPath }/resources/image/duke_swing.gif">
				</a>
			</td>
			<td>
				<h1><font size="30">스프링 메이븐 실습 홈페이지</font></h1>
			</td>			
			<td>
				<h3>
					<a href="#">로그인</a>
				</h3>
			</td>
		</tr>
	</table>
</body>

</html>