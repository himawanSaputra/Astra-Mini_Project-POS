<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/24/2019
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <title>Point of Sales - Login</title>
</head>
<body>
<div class="container">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-md-4 card p-4 shadow p-3 mb-5 bg-white rounded">
            <div class="row mb-4">
                <div class="col">
                    <h3 align="center">Point Of Sales</h3>
                    <h4 align="center">Login</h4>
                </div>
            </div>

            <c:if test = "${message != null}">
                <span class="alert alert-success mb-4 w-100">${message}</span>
            </c:if>
            <c:if test = "${error != null}">
                <span class="alert alert-danger mb-4 w-100">${error}</span>
            </c:if>
            <form:form method="post" action="/login">
                <div class="form-group">
                    <label for="loginUsernameInput">Username</label>
                    <input required="required" class="form-control" type="text" name="username" id="loginUsernameInput"/>
                </div>
                <div class="form-group">
                    <label for="loginPasswordInput">Password</label>
                    <input required="required" class="form-control" type="password" name="password" id="loginPasswordInput"/>
                </div>
                <div class="row">
                    <div class="col-6 justify-content-start">
                        <a href="<c:url value="/forgot_password"/>">Forgot Password</a>
                    </div>
                    <div class="col-6 justify-content-end">
                        <button class="btn btn-primary float-right" type="submit">Login</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
