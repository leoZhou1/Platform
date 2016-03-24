<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springmvc/user/insertUser.do">
		用户名：<input type="text" name="user.name"/>
		密码：<input type="password" name="user.password"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>