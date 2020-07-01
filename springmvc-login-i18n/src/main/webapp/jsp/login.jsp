<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="global.login.link.title" /></title>
</head>
<body>
	${message}
	<frm:form modelAttribute="user" action="loginProcess" method="POST">
		<table>
			<tr>
				<td><spring:message code="global.username.title" /></td>
				<td><frm:input path="userName" id="userName" /></td>
			</tr>
			<tr>
				<td><spring:message code="global.password.title" /></td>
				<td><frm:password path="pwd" id="pwd" /></td>
			</tr>
		</table>
		<frm:button id="login" name="login">
			<spring:message code="global.login.link.title" />
		</frm:button>
	</frm:form>
	<div>
		<spring:message code="global.question.account" />
		<a href="register"><spring:message
				code="global.register.link.title" /></a>
	</div>

	<div align="right">
		<!-- Select Language : <a href="#" lang="en">English</a> | <a href="#" lang="vi">VN</a> -->

		Select Language : <a href="?lang=en">English</a> | <a href="?lang=vi">VN</a>
	</div>
</body>
</html>