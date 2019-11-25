<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/24/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>
</head>
<body>

<h3>Login Page</h3>
${error }
<form method="post"
      action="${pageContext.request.contextPath }/account/login">
    <table border="0" cellpadding="2" cellspacing="2">
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>

</body>
</html>
