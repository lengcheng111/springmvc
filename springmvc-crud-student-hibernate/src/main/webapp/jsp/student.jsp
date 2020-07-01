<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}

.fa_custom {
	color: #0099CC;
	margin-left: 5px;
}
</style>
<c:set var="asc" value="fa fa-sort-asc fa_custom" />
<c:set var="desc" value="fa fa-sort-desc fa_custom" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage student</title>
</head>
<body>
	<div align="center">
	<%String contextPath = request.getContextPath(); %>
		<frm:form modelAttribute="student" action="studentProcess"
			method="get">
			<frm:hidden path="id" />
			<table>
				<tr>
					<td>Name</td>
					<td><frm:input path="name" id="name" /></td>
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
					<td><frm:input path="email" id="email" /></td>
				</tr>
			</table>
			<button id="add" name="add" value="Add">Add</button>
			<button id="update" name="update" value="Update">update</button>
			<frm:button id="reset" name="reset">Reset</frm:button>
		</frm:form>
		<br />
		<form action="studentSearch">
			<input name="search" type="text"> <input type="submit"
				value="Search">
		</form>
		<br />
		<table>
			<tr>
				<th>id
					<a href="<%= contextPath %>/order?order=${sortingStyle }&columnName=id"> <c:choose>
							<c:when test="${sortingStyle eq 'asc'}">
								<i class="${asc }"></i>
							</c:when>
							<c:otherwise>
								<i class="${desc }"></i>
							</c:otherwise>
						</c:choose>
				</a>
				</th>
				<th>name <a href="<%= contextPath %>/order?order=${sortingStyle }&columnName=name"> <c:choose>
							<c:when test="${sortingStyle eq 'asc'}">
								<i class="${asc }"></i>
							</c:when>
							<c:otherwise>
								<i class="${desc }"></i>
							</c:otherwise>
						</c:choose>
				</a>
				</th>
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
					<td><a href="<%= contextPath %>/edit?id=${st.id}">Edit</a> <a
						href="<%= contextPath %>/delete/${st.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<div>
			<%
			Integer totalPage = (Integer) request.getAttribute("totalPage");
				for (int i = 0; i < totalPage; i++) {
			%>
			<a href="<%= contextPath %>/showStudent/<%=i%>"><%=i+1%></a>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>