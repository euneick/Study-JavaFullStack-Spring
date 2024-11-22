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
	<form action="${ contextPath }/Member/registPro.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력해주세요" > <br>
		<input type="password" name="pwd" placeholder="비밀번호를 입력해주세요" > <br>
		<input type="text" name="name" placeholder="이름을 입력해주세요" > <br>
		<input type="text" name="email" placeholder="이메일을 입력해주세요" > <br>
		<input type="submit" value="회원가입하기">
		<input type="reset" value="다시 쓰기">
	</form>
</body>

</html>