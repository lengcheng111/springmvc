<%-- 
    Document   : update
    Created on : Sep 23, 2019, 11:27:25 PM
    Author     : truonglv
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <h1>Update Student!</h1>
        <form action="StudentController" name="Update">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" readonly="true" name="txtId" value="<c:out value="${studentById.id}"/>"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="txtName" value="<c:out value="${studentById.name}"/>"/></td>
                </tr>
            </table>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
