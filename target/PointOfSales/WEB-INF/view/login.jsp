<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/24/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
    <title>Point of Sales - Login</title>
</head>
<body>
<div class="row justify-content-center">
    <div class="col-md-4 offset-4">
        <h3>Point Of Sales</h3>
        <h4>Login</h4>

        <form:form method="post"
              action="/login">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input class="form-control" type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input class="form-control" type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input class="btn btn-primary" type="submit" value="Login"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

</body>
</html>
