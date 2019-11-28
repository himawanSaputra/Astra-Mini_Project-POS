<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/25/2019
  Time: 11:04 PM
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
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-md-4 card p-4">
            <div class="row mb-4">
                <div class="col">
                    <h4 align="center">Forgot Password</h4>
                </div>
            </div>

            <c:if test = "${error != null}">
                <span class="alert alert-danger mb-4 w-100">${error}</span>
            </c:if>
            <form:form method="post" action="/reset_password">
                <div class="form-group">
                    <label for="forgotPasswordEmailInput">Email</label>
                    <input required="required" class="form-control" type="text" name="email" id="forgotPasswordEmailInput"/>
                </div>
                <div class="form-group">
                    <label for="forgotPasswordPasswordInput">Password</label>
                    <input required="required" class="form-control" type="password" name="password" id="forgotPasswordPasswordInput"/>
                </div>
                <div class="form-group">
                    <label for="forgotPasswordRePasswordInput">Retype Password</label>
                    <input required="required" class="form-control" type="password" name="repassword" id="forgotPasswordRePasswordInput"/>
                </div>
                <div class="row">
                    <div class="col-6">
                        <a href="<c:url value="/"/>">Back</a>
                    </div>
                    <div class="col-6">
                        <button class="btn btn-primary float-right" type="submit">Submit</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>

