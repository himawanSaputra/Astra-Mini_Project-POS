<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Arman
  Date: 11/25/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" href=<c:url value="/resources/bootstrap/css/bootstrap-min.css" />>--%>
<%--    <script src="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />"></script>--%>
<%--    <title>Category</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>
</head>
<body>

<div class="container">

    <div>
        <h3>
            Category
        </h3>
    </div>

    <div>
        <hr>
        <div class="row">
            <div class="form-group col-sm-3" align="left">
                <input id="myInput" class="form-control" type="search" placeholder="Search"/>
            </div>
            <div class="form-group col-sm-9" align="right">
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#createCategory">
                    Create
                </button>
            </div>

        </div>
    </div>

    <div>
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
                <tr>
                    <td style="display: none">${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.active}</td>
                    <td><a data-toggle="modal"  onclick="toLink(${category.id})" data-target="#editCategory">View</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="createCategory" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Category</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form:form method="post" action="/saveCategory" modelAttribute="category"
                           class="form-horizontal">
                    <form:input class="form-control" type="input" path="name" placeholder="Category Name"/>
                    <div class="modal-footer">
                    <button type="reset"  class="btn btn-primary">Cancel</button>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editCategory" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Category</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form:form method="post" action="/editCategory" modelAttribute="category" class="form-horizontal">
                    <form:input class="form-control" type="text" path="name" placeholder="Category Name"/>
                    <form:input path="active" cssStyle="display: none" />
                    <form:input path="id" cssStyle="display: none" />
                    <div class="modal-footer">
<%--                    <form:input value="0" path="active"></form:input>--%>
                        <form:button type="button" method="post" path="active" class="btn btn-danger" >X</form:button>
                        <button type="reset" class="btn btn-primary">Cancel</button>
                        <button type="submit" class="btn btn-primary"  value="Save">Save </button>
                    </div>
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
</script>

<script>

    function toLink(id) {
        console.log("toLink"+id);

        $.ajax({
            url: '${pageContext.request.contextPath}/update/'+id,
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                asd = JSON.stringify(data);
                console.log(asd);
                $('#id').val(data.id);
                $('#active').val(data.active);
                $('#name').val(data.name);
            },
            error: function (error) {
                alert(error);
            }
        })
    }

</script>
</html>