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
    <form action="StudentController" name="Update" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="txtId" value="${studentById.id}"/></td>
            </tr>
            <tr>
                <td>Fist name:</td>
                <td><input type="text" name="txtFistName" value="${studentById.firstName}"/></td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><input type="text" name="txtLastName" value="${studentById.lastName}"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="txtEmail" value="${studentById.email}"/></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="text" name="txtGender" value="${studentById.gender}"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="txtAddress" value="${studentById.ipAddress}"/></td>
            </tr>
            <tr>
                <td>Class</td>
                <td>
                    <select name="idClass">
                        <c:forEach var="class" items="${classes}">
                            <option  
                                <c:if test="${class.id == studentById.idClass}">selected="true"</c:if> 
                                value="${class.id}">${class.ten}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" name="action" value="Update"/>
    </form>
</body>
</html>
