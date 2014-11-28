<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<security:authorize access="isRememberMe()" />
	<h1>登录界面</h1>
	<form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<th>用户名：</th>
				<td><input name="j_username" type="text" /></td>
			</tr>
			<tr>
				<th>密&nbsp;&nbsp;&nbsp;&nbsp;码：</th>
				<td><input name="j_password" type="password" /></td>
			</tr>
			<tr>
				<th>记住我：</th>
				<td><input id="_spring_security_remember_me" name="_spring_security_remember_me"
					type="checkbox" value="true" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录"><input type="reset" value="清空" /></td>
			</tr>
		</table>
	</form>
</body>
</html>