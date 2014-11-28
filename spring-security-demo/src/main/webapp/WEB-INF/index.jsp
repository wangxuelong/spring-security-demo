<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h1>
		这是首页欢迎:
		<security:authentication property="name"></security:authentication>
	</h1>
	<a href="admin.jsp">进入admin页面</a>
	<a href="other.jsp">进入其他页面</a>
	<a href="j_spring_security_logout">退出</a>
</body>
</html>