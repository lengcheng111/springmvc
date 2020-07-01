<%-- 
    Document   : students.jsp
    Created on : Sep 19, 2019, 9:48:01 PM
    Author     : truonglv
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <body>
        <div style="margin:auto;width: 50%">
            <form action="Search" name="Search" method="post">
                <input type="text" name="txtSearch" value="${requestScope.txtSearch}"/>
                <input type="submit" name="btnSearch" value="Search Student"/>
            </form>
        </div>
        <br/>
        <table style="border: solid 1px;margin:auto;width: 50%">
            <tr>
                <th>stt</th>
                <th>name</th>
                <th>action</th>
            </tr>
            <% int i = 1;%>
            <c:forEach items="${students}" var="item">
                <tr>
                    <td><%= i++%></td>
                    <td>${item.name}</td>
                    <td>
                        <a href="StudentController?action=Delete&id=${item.id}">Delete</a>|
                        <a href="StudentController?action=AddCart&id=${item.id}">Add to Cart</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="newStudent.jsp">Add new</a><br/>
        <a href="StudentController?action=ViewCart">View Cart</a><br/>
        <a href="home.jsp">Home</a>
        <a href="StudentController?action=list">Student list</a>
    </body>
</html>
