<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage student</title>
</head>
<body>
	<div align="center">
		<frm:form modelAttribute="student" action="studentProcess"
			method="get">
			<frm:errors path="*" element="ul" />
			<frm:hidden path="id" />
			<table>
				<tr>
					<td>Name</td>
					<td>
						<frm:input path="name" id="name" />
						<frm:errors path="name"/>
					</td>
				</tr>
				<tr>
					<td>Age</td>
					<td><frm:input path="age" id="age" /></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><frm:input path="phone" id="phone" /></td>
				</tr>
				<tr>
					<td>email</td>
					<td><frm:input path="email" id="email" /><frm:errors path="email"/></td>
				</tr>
			</table>
			<button id="add" name="add" value="Add">Add</button>
			<button id="update" name="update" value="Update">update</button>
			<frm:button id="reset" name="reset">Reset</frm:button>
		</frm:form>
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
				<th>phone</th>
				<th>email</th>
				<th>action</th>
			</tr>
			<c:forEach items="${students}" var="st">
				<tr>
					<td>${st.id}</td>
					<td>${st.name}</td>
					<td>${st.age}</td>
					<td>${st.phone}</td>
					<td>${st.email}</td>
					<td><a href="edit?id=${st.id}">Edit</a> <a
						href="delete/${st.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>