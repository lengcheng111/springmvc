<%-- 
    Document   : newStudent.jsp
    Created on : Sep 23, 2019, 10:44:08 PM
    Author     : truonglv
--%>

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
                    <td>Name:</td>
                    <td><input type="text" name="txtName" value=""/></td>
                </tr>
            </table>
            <input type="submit" name="action" value="Save"/>
        </form>
    </body>
</html>
