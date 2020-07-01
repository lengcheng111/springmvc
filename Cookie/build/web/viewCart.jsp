<%-- 
    Document   : viewCart
    Created on : Sep 25, 2019, 10:26:47 PM
    Author     : truonglv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

<table>
    <tr>
        <th>Id</th>
        <th>Value</th>
        <th>Action</th>
    </tr>
    <c:forEach var="cookieVal" items="${cookies}" > 
        <tr>
            <td align="right">${cookieVal.name}</td>
            <td>${cookieVal.value}</td>
            <td><a href="StudentController?action=DeleteCookie&name=${cookieVal.name}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="home.jsp">Home</a>
<a href="StudentController?action=list">Student list</a>

</html>
