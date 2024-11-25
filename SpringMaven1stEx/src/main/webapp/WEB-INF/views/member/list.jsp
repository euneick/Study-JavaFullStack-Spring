<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${ memberList }">
			<tr align="center">
				<td>${ member.id }</td>
				<td>${ member.pwd }</td>
				<td>${ member.name }</td>
				<td>${ member.email }</td>
				<td>${ member.joinDate }</td>
				<td><b><a href="${ contextPath }/Member/update.do?id=${ member.id }">수정</a></b></td>
				<td><b><a href="${ contextPath }/Member/deletePro.do?id=${ member.id }">삭제</a></b></td>
			</tr>
		</c:forEach>
	</table>	
	<a href="${ contextPath }/Member/regist.do">
		<h1 style="text-align: center">회원가입</h1>
	</a>
</body>

</html>