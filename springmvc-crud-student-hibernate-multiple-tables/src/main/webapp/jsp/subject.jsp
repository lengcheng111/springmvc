<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage subject</title>
</head>
<body>
	<div align="center">
		<frm:form modelAttribute="subject" action="subjectProcess"
			method="get">
			<frm:hidden path="id" />
			<table>
				<tr>
					<td>Name</td>
					<td><frm:input path="name" id="name" /></td>
				</tr>
				<tr>
					<td>Student name</td>
					<td>
						<frm:select path="studentPK">
							<c:forEach items="${students}" var="sv">
								<frm:option value="${sv.id}">${sv.id} - ${sv.name }</frm:option>
							</c:forEach>
						</frm:select>
					</td>
				</tr>
			</table>
			<button id="add" name="add" value="Add">Add</button>
			<button id="update" name="update" value="Update">update</button>
			<frm:button id="reset" name="reset">Reset</frm:button>
		</frm:form>
		<table>
			<tr>
				<th>id</th>
				<th>student id</th>
				<th>name</th>
				<th>action</th>
			</tr>
			<c:forEach items="${subjects}" var="subject">
				<tr>
					<td>${subject.id}</td>
					<td>${subject.student.id}</td>
					<td>${subject.name}</td>
					<td><a href="edit?id=${subject.id}">Edit</a> <a
						href="delete/${subject.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/">Home</a> <br/>
		<a href="${pageContext.request.contextPath}/studentManagement/showStudent">Manage student</a>
	</div>
</body>
</html>