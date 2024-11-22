<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="${ pageContext.request.contextPath }/test/login5.do" method="post">
		<input type="hidden" name="email" value="admin@test.com" >
		<table width="400px">
			<tr>
				<td>아이디<input size="10" name="userId"></td>
			</tr>
			<tr>
				<td>이름<input size="10" name="userName"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>