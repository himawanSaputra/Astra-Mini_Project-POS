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
    <title>Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


<div class="row">
    <div class="col-12">
        <c:if test="${sessionScope.user.mstRole.id == 1}">
            <div>
                <h3>
                    ADD EMPLOYEE
                </h3>
            </div>

            <hr>

            <div>
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                            ${error}
                    </div>
                </c:if>

                <form:form action="/add_employee" name="employeeForm" method="post" modelAttribute="employee" >
                    <div class="row">
                        <form:hidden class="form-control"  id="idmstuser" path="id"/>
                        <div class="col-3">
                            <form:input type="text" class="form-control" placeholder="First name"
                                        path="firstName" id="firstname" required="required"/>
                        </div>
                        <div class="col-3">
                            <form:input type="text" class="form-control" placeholder="Last name"
                                        path="lastName" id="lastname" required="required"/>
                        </div>
                        <div class="col-3">
                            <form:input type="text" class="form-control" placeholder="Email"
                                        path="email" id="email" required="required"/>
                        </div>
                        <form:hidden class="form-control"  id="active" path="active"/>
                        <div class="col-3">
                            <form:select class="form-control" path="title" id="title">
                                <form:option value="mister">Mr</form:option>
                                <form:option value="miss">Ms</form:option>
                            </form:select>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <div class="col-2">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Assign Outlet
                            </button>
                        </div>
                        <div class="col-4">
                            <div class="custom-control custom-checkbox">
                                <form:checkbox cssClass="custom-control-input" onclick="myFunction()" path="haveAccount" id="haveaccount"/>
                                <label class="custom-control-label" for="haveaccount">Create Account?</label>
                            </div>
                        </div>
                    </div>

                    <div id="hide-user" class="row mt-5">
                        <div class="col-4">
                            <form:select path="mstUser.mstRole.id" class="form-control" id="role" style="width: 100%;" required="required">
                                <form:option value="0" label="-SELECT ROLE-"/>
                                <form:options items="${roleList}"/>
                            </form:select>
                        </div>
                        <div class="col-4">
                            <form:input for="disabledTextInput" type="text" class="form-control" placeholder="User Name"
                                        path="mstUser.username" id="username"/>
                        </div>
                        <div class="col-4">
                            <form:input for="disabledTextInput" type="text" class="form-control" placeholder="Password"
                                        path="mstUser.password" id="password"/>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <div class="col 12 text-right">
                            <button type="reset" class="btn btn-secondary">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>

                    <div id="selected_outlet" hidden>

                    </div>
                </form:form>
            </div>
        </c:if>

        <hr>

        <div>
            <h3>
                Staff List
            </h3>
        </div>

        <hr>

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

                    <c:if test="${cur_employee.active}">

                        <tr>
                            <td>${cur_employee.firstName}</td>
                            <td>${cur_employee.email}</td>
                            <td>${cur_employee.haveAccount}</td>
                            <td>
                                <c:if test="${!cur_employee.employeeOutlet.isEmpty()}">
                                ${cur_employee.employeeOutlet.get(0).mstOutlet.name}
                                </c:if>
                            </td>
                            <td>${cur_employee.mstUser.mstRole.name} </td>
                            <td>
                                <c:if test="${sessionScope.user.mstRole.id == 1}">
                                    <button class="btn btn-outline-primary"
                                            onclick="location.href='<c:url value="/edit_employee/${cur_employee.id}"/>'">
                                        Edit
                                    </button>
<%--                                    <a href="<c:url value='/edit_employee/${cur_employee.id}'/>">Edit</a>--%>
                                    <button class="btn btn-danger" onclick="location.href='<c:url value="/remove_employee/${cur_employee.id}"/>'">X</button>
                                </c:if>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- MODAL FOR ASSIGNING EMPLOYEE TO OUTLET -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Assign Outlet to Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <c:forEach var="outlet" items="${all_outlets}">
                    <div class="row">
                        <div class="col-10 offset-1 custom-control custom-checkbox">
                            <input type="checkbox"
                                   class="custom-control-input checkbox_outlet"
                                   id="checkbox_outlet_${outlet.id}"
                                   value="${outlet.id}">
                            <label class="custom-control-label" for="checkbox_outlet_${outlet.id}">${outlet.name}</label>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="assignOutlets()" data-dismiss="modal">Save changes</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script>
    $(document).ready(function(){
        $('#hide-user').hide();
    });

    function myFunction() {
        var checkBox = document.getElementById("haveaccount");
        if (checkBox.checked == true){
            $('#username').prop('required', true);
            $('#password').prop('required', true);
            $('#hide-user').show();
        } else {
            $('#username').prop('required', false);
            $('#password').prop('required', false);
            $('#hide-user').hide();
        }
    }

    function assignOutlets(){
        $('#selected_outlet').empty();
        $('.checkbox_outlet').each(function (){
            if($(this).prop('checked')){
                $('#selected_outlet').append(
                    '<input name="selected_outlet" value="' + $(this).prop('value') + '">'
                );
            }
        });


    }
</script>
