<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>
</head>
<body>

	<h3>Upload One File:</h3>

	<form:form modelAttribute="uploadModel" action="doupload" method="POST" enctype="multipart/form-data">
        File to upload: <form:input path="fileDatas" type="file" />

		<br />
		<br />
		<input type="submit" value="Upload">

	</form:form>
</body>
</html>