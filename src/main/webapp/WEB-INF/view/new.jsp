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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.miqn.js"></script>
</head>
<body>


<div class="container">

    <div>
        <h3>
            ADD EMPLOYEE
        </h3>
    </div>

    <div >
        <div class="row">
            <div class="input-group col-sm-3">
                <input type="text" class="form-control" placeholder="First Name" aria-label="First Name" aria-describedby="basic-addon1">
            </div>
            <div class="input-group col-sm-3">
                <input type="text" class="form-control" placeholder="Last Name" aria-label="Last Name" aria-describedby="basic-addon1">
            </div>
            <div class="input-group col-sm-3">
                <input type="text" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="basic-addon1">
            </div>
            <div class="select col-sm-3">
                <select class="select btn-primary ">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="opel">Opel</option>
                    <option value="audi">Audi</option>
                </select>
            </div>
        </div>
    </div>

    <div>
        <div class="row" style="margin-top: 50px; margin-left: 10px">
            <div >
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    Launch demo modal
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="form-check" style="margin-left: 50px">
                <input type="checkbox" class="form-check-input" id="materialChecked2" checked>
                <label class="form-check-label" for="materialChecked2">Create ACcount ?</label>
            </div>
        </div>
        <hr>
    </div>


    <div>
        <div class="row">
            <div style="margin-right: 50px">
                <button type="button" class="btn btn-danger">Cancel</button>
            </div>

            <div >
                <button type="button" class="btn btn-primary">Save</button>
            </div>
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
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td>${employee.firstName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.haveAccount}</td>
                    <td>${employee.mstUser.mstRole.description}</td>
                    <td>${employee.mstUser.mstRole.name}</td>
                    <td>Edit <span><button type="button" class="btn btn-danger">X</button></span></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
