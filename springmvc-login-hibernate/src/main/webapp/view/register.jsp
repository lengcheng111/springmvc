<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
		${message}
		<frm:form modelAttribute="user" action="registerProcess" method="POST">
			<table>
				<tr>
					<td>User name</td>
					<td><frm:input path="userName" id="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><frm:password path="pwd" id="pwd" /></td>
				</tr>
			</table>
			<frm:button id="register" name="register">Register</frm:button>
		</frm:form>
</body>
</html>