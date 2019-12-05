<%--
  Created by IntelliJ IDEA.
  User: agrhimaw6897
  Date: 12/3/2019
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


<div class="row">
    <div class="col-12">
        <div class="mb-5">
            <h3 >
                EDIT EMPLOYEE
            </h3>
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>
        </div>

        <div>
            <form:form action="/edit_employee" name="employeeForm" method="post" modelAttribute="employee" >
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

                <div id="hide-user" class="row mt-5" <c:if test="${!employee.haveAccount}">style="display: none"</c:if>>
                    <form:hidden path="mstUser.id"/>
                    <div class="col-4">
                        <form:select path="mstUser.mstRole.id" class="form-control" id="role" style="width: 100%;" required="required">
                            <form:option value="0" label="-SELECT ROLE-"/>
                            <form:options items="${roles_map}"/>
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
                        <button type="submit" class="btn btn-secondary" name="cancel">Cancel</button>
                        <button type="submit" class="btn btn-primary" name="save">Save</button>
                    </div>
                </div>

                <div id="selected_outlet" hidden>
                    <c:forEach var="cur_selected_outlet" items="${employee_outlet_list}">
                        <input name="selected_outlet" value="${cur_selected_outlet.mstOutlet.id}">
                    </c:forEach>
                </div>
            </form:form>
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
                <c:forEach var="outlet" items="${outlets_list}">
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
    function myFunction() {
        var checkBox = document.getElementById("haveaccount");
        var text = document.getElementById("hide-user");
        if (checkBox.checked == true){
            $('#username').prop('required', true);
            $('#password').prop('required', true);
            text.style.display = "block";
        } else {
            $('#username').prop('required', false);
            $('#password').prop('required', false);
            text.style.display = "none";
        }
    }

    $(document).ready(function(){
        var selectedOutlets = [];
        <c:forEach var="cur_selected_outlet" items="${employee_outlet_list}">
            selectedOutlets.push(${cur_selected_outlet.mstOutlet.id});
        </c:forEach>

        $(".checkbox_outlet").each(function(index){
            if($.inArray(parseInt($(this).val()), selectedOutlets) !== -1){
                $(this).prop('checked', true);
            }
        });
    });

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

