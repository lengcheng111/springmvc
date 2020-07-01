<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload multiple file</title>
</head>
<body>
	<!-- MyUploadForm -->
	<form:form modelAttribute="uploadModel" method="POST" action="UploadMultiple"
		enctype="multipart/form-data">
         
        Description:
        <br>
		<form:input path="description" style="width:300px;" />
		<br />
		<br />                 
     
        File to upload (1): <form:input path="fileDatas" type="file" />
		<br />      
        File to upload (2): <form:input path="fileDatas" type="file" />
		<br />    
        File to upload (3): <form:input path="fileDatas" type="file" />
		<br />    
        File to upload (4): <form:input path="fileDatas" type="file" />
		<br />    
        File to upload (5): <form:input path="fileDatas" type="file" />
		<br />

		<input type="submit" value="Upload">

	</form:form>
	<br />
	<a href="index.jsp">Home</a>
</body>
</html>
