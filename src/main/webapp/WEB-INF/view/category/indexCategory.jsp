<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Arman
  Date: 11/25/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Category</title>
</head>
<body>

<div class="row">
    <div class="col-12">

        <div class="row">
            <div class="form-group col-sm-3" align="left">
                <input id="myInput" class="form-control" type="search" placeholder="Search"/>
            </div>
            <div class="form-group col-sm-9" align="right">
                <c:if test="${sessionScope.user.mstRole.id == 1}">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createCategory">
                        Create
                    </button>
                </c:if>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" style="display: none">id</th>
                        <th scope="col">Category Name</th>
                        <th scope="col">Item Stocks</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <c:forEach var="category" items="${allCategory}">
                        <c:if test="${category.active==true}">
                            <tr>
                                <td  style="display: none">${category.id}</td>
                                <td>${category.name}</td>
                                <td>10</td>
                                <td style="display: none"> ${category.active}</td>
                                <td>
                                    <c:if test="${sessionScope.user.mstRole.id == 1}">
                                        <a href="#" id="edit-data" data-toggle="modal" onclick="toLink(${category.id})" data-target="#editCategory">
                                            Edit
                                        </a>
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
</div>

<!-- CREATE CATEGORY MODEL -->
<div class="modal fade" id="createCategory" role="dialog">
    <div class="modal-dialog">

        <form:form method="post" action="/saveCategory" modelAttribute="category"
                   class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Category</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form:input class="form-control" type="input" path="name" placeholder="Category Name" required="required"/>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-12 text-right">
                            <button type="reset"  class="btn btn-secondary">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>

                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

<!-- EDIT CATEGORY MODAL -->
<div class="modal fade" id="editCategory" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <form:form method="post" action="/editCategory" modelAttribute="category" class="form-horizontal">
                <div class="modal-header">
                    <h4 class="modal-title">Category</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form:input path="name" class="form-control" type="text" id="nameEdit" placeholder="Category Name" required="required"/>
                    <form:hidden path="active" id="activeEdit" />
                    <form:hidden path="id" cssStyle="display: none" id="idEdit" />
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-primary">Cancel</button>
                    <button type="submit" class="btn btn-primary">Save </button>
                </div>
            </form:form>
            <div class="modal-footer">
                <form:form method="post" action="/removeStatusCategory" modelAttribute="category" class="form-horizontal" >
                    <form:hidden path="id" id="idCategory"/>
                    <form:hidden path="active" id="activeCategory"/>
                    <form:hidden path="name" id="nameCategory"/>
                    <button  type="submit" class="btn btn-danger">X</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });

    function toLink(id) {
        console.log("toLink"+id);

        $.ajax({
            url: '${pageContext.request.contextPath}/update/'+id,
            method: 'GET',
            dataType: 'json',
            success: function (data) {

                asd = JSON.stringify(data);
                console.log(asd);
                $('#idEdit').val(data.id);
                $('#activeEdit').val(data.active);
                $('#nameEdit').val(data.name);
                $('#idCategory').val(data.id);
                $('#activeCategory').val(data.active);
                $('#nameCategory').val(data.name);

            },
            error: function (error) {
                alert(error);
            }
        })
    }
</script>
</html>