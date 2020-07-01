<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Upload One File:</h3>

	<!-- MyUploadForm -->
	<form:form modelAttribute="uploadModel" action="Upload" method="POST"
		enctype="multipart/form-data">
        Description:
        <br>
		<form:input path="description" style="width:300px;" />
		<br />
		<br />  
             
        File to upload: <form:input path="fileDatas" type="file" />
		<br />

		<input type="submit" value="Upload">

	</form:form>

	<a href="index.jsp">Home</a>

</body>
</html>