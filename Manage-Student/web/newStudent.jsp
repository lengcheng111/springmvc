<%-- 
    Document   : newStudent.jsp
    Created on : Sep 23, 2019, 10:44:08 PM
    Author     : truonglv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new Student!</h1>
        <form action="StudentController" name="action">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="txtId" value=""/></td>
                </tr>
                <tr>
                    <td>Fist name:</td>
                    <td><input type="text" name="txtFistName" value=""/></td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input type="text" name="txtLastName" value=""/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="txtEmail" value=""/></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td><input type="text" name="txtGender" value=""/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="txtAddress" value=""/></td>
                </tr>
                <tr>
                    <td>class:</td>
                    <td>
                        <select name="idClass">
                            <c:forEach var="item" items="${classes}">
                                <option value="${item.id}">${item.ten}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="action" value="Save"/>
        </form>
    </body>
</html>
