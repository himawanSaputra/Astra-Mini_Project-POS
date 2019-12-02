<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--

  Created by IntelliJ IDEA.
  User: liamra
  Date: 11/25/2019
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />">
</head>
<body>


<div class="container">

    <div>
        <h3>
            ADD EMPLOYEE
        </h3>
    </div>

    <div >
        <form:form action="employee" name="employeeForm" method="post" modelAttribute="employee" >
            <div class="row">
                <div class="col">
                    <form:input type="hidden" class="form-control"  id="id" path="id"/>
                </div>
                <div class="col">
                    <form:input type="text" class="form-control" placeholder="First name"  path="firstName" id="firstname"/>
                </div>
                <div class="col">
                    <form:input type="text" class="form-control" placeholder="Last name" path="lastName" id="lastname"/>
                </div>
                <div class="col">
                    <form:input type="text" class="form-control" placeholder="Email" path="email" id="email"/>
                </div>
                <div class="col">
                    <form:input type="hidden" class="form-control"  id="active" path="active"/>
                </div>
                <div class="col">
                    <form:select path="title" id="title">
                        <form:option value="mister">Mr</form:option>
                        <form:option value="miss">Ms</form:option>
                    </form:select>
                </div>

            </div>

            <div class="row">
                <div class="col">
                    <span class="checkbox"><form:checkbox onclick="myFunction()" path="haveAccount" id="haveaccount" /> Create Account?</span>
                </div>
            </div>

            <div id="hide-user" class="hide-field row" style="margin-top: 25px ; display: none"  >
                <div class="col">
                    <form:select path="mstUser.mstRole" class="form-control select2" id="role" style="width: 100%;"  >
                        <form:option value="0" label="-SELECT ROLE-"/>
                        <form:options items="${roleList}"/>
                    </form:select>
                </div>
                <div class="col">
                    <form:input for="disabledTextInput" type="text" class="form-control" placeholder="User Name" path="mstUser.username" id="username"/>
                </div>
                <div class="col">
                    <form:input for="disabledTextInput" type="text" class="form-control" placeholder="Password" path="mstUser.password" id="password"/>
                </div>
            </div>

            <div class="row" style="margin-top: 25px">
<%--                <div class="col">--%>
<%--                    <button class="btn btn-outline-secondary">Cancel</button>--%>
<%--                </div>--%>
                <div class="col">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </form:form>
    </div>


    <div>
        <div class="row">

        </div>
    </div>

    <div style="margin-top: 50px">
        <h4>
            Staff List
        </h4>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Have Account?</th>
                <th scope="col">Outlet Accsess</th>
                <th scope="col">Role</th>
                <th scope="col">#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cur_employee" items="${employees}">
                    <tr>
                        <td>${cur_employee.firstName}</td>
                        <td>${cur_employee.email}</td>
                        <td>${cur_employee.haveAccount}</td>
                        <td>${cur_employee.mstUser.mstRole.description} </td>
                        <td>${cur_employee.mstUser.mstRole.name} </td>
                        <td>Edit <span><button type="button" class="btn btn-danger">X</button></span></td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function myFunction() {
        var checkBox = document.getElementById("haveaccount");
        var text = document.getElementById("hide-user");
        if (checkBox.checked == true){
            text.style.display = "block";
        } else {
            text.style.display = "none";
        }
    }
</script>
</body>
</html>
