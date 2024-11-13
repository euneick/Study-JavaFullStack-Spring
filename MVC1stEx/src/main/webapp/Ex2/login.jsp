<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="<%= request.getContextPath() %>/Ex2/loginPro.do" method="post">
		<input type="text" name="user_id" placeholder="아이디 입력"><br>
		<input type="password" name="user_pw" placeholder="비밀번호 입력"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시쓰기">
	</form>
</body>

</html>