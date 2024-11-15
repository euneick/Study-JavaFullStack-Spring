<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<form action="${ contextPath }/Member/updatePro.do" method="post">
		<input type="text" name="id" value="${ member.id }" readonly> <br>
		<input type="password" name="pass" value="${ member.pass }" placeholder="비밀번호를 입력해주세요" > <br>
		<input type="text" name="name" value="${ member.name }" placeholder="이름을 입력해주세요" > <br>
		<input type="text" name="email" value="${ member.email }" placeholder="이메일을 입력해주세요" > <br>
		<input type="submit" value="수정하기">
		<input type="reset" value="다시쓰기">
	</form>
</body>

</html>