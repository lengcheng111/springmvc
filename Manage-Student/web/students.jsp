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
        <title>Quan ly sinh vien</title>
    </head>
    <body>
        <div style="margin:auto;width: 100%">
            <form action="Search" name="Search" method="post">
                <input type="text" name="txtSearch" value="${requestScope.txtSearch}"/>
                <input type="submit" name="btnSearch" value="Search Student"/>
            </form>
        </div>
        <br/>
        <a href="StudentController?action=AddNew">Add new</a><br/>
        <a href="home.jsp">Home</a>
        <table style="border: solid 1px;margin:auto;width: 100%">
            <tr>
                <th>ID</th>
                <th>fist name</th>
                <th>last name</th>
                <th>
                    fist name
                    <a style="float:right" href="StudentController?action=order">order</a>
                </th>
                <th>email</th>
                <th>gender</th>
                <th>address</th>
                <th>action</th>
            </tr>
            <c:forEach items="${students}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.email}</td>
                    <td>${item.gender}</td>
                    <td>${item.ipAddress}</td>
                    <td>${item.idClass}</td>
                    <td>
                        <a href="StudentController?action=Delete&id=${item.id}">Delete</a>|
                        <a href="StudentController?action=Edit&id=${item.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="newStudent.jsp">Add new</a><br/>
        <a href="home.jsp">Home</a>
    </body>
</html>
