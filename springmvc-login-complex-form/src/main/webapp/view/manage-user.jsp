<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
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
<title>Quản lý người dùng</title>

</head>
<body>

<frm:form modelAttribute="userView" action="doUser" >
		<%-- <frm:hidden path="id"/> --%>
		<table>
			<tr>
				<td>Name</td>
				<td><frm:input path="userName" id="userName" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><frm:password path="passWord" id="passWord" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><frm:select path="country">
						<frm:option value="VI">Viet Nam</frm:option>
						<frm:option value="EN">English</frm:option>
					</frm:select></td>
			</tr>
			<tr>
				<td>Level</td>
				<td><frm:radiobutton path="level" value="DOCTOR" />Doctor<frm:radiobutton
						path="level" value="MASTER" />Master</td>
			</tr>
			<tr>
				<td>Title</td>
				<td><frm:select path="titles">
						<frm:option value="CEO">CEO</frm:option>
						<frm:option value="DIRECTOR">DIRECTOR</frm:option>
					</frm:select></td>
			</tr>
			<tr>
				<td>Hobbies</td>
				<td><frm:checkbox path="hobbies" value="TRAVELLING" />Travelling <frm:checkbox
						path="hobbies" value="MUSIC" />Music</td>
			</tr>
		</table>
		<br/>
		<frm:button id="save" name="save" value="Save">Save</frm:button>
		<frm:button id="update" name="update" value="Update">Update</frm:button>
	</frm:form>
</body>
</html>