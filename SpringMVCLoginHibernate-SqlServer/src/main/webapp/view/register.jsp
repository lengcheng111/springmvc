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

	<table>
		<tr>
			<th>STT</th>
			<th>name</th>
			<th>action</th>
		</tr>
		<%int i=1; %>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><%=i++ %></td>
				<td>${user.userName}</td>
				<td><a href="edit?id=${user.userName}">Edit</a> | <a
					href="delete?id=${user.userName}">Delete</a></td>
					<br/>
					<i>chức năng edit, sinh viên làm bài tập bài lab2,3:
					yêu cầu: khi click vào edit, dữ liệu sẽ được hiển thị lên form update.jsp, và xuất hiện button update. xem hình
					<a href="https://github.com/lengcheng111/springmvc-login-hibernate-Mysql/blob/master/Screenshot%20from%202020-01-30%2013-34-09.png">ảnh</a>
					Có chức năng update dữ liệu </i>
			</tr>
		</c:forEach>
	</table>
</body>
</html>