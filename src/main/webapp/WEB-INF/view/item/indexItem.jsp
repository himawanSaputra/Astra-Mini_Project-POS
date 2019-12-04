<%--
  Created by IntelliJ IDEA.
  User: Arman
  Date: 11/29/2019
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <script src="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />"></script>
    <title>Item</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div>
        <h3>
            Items
        </h3>
    </div>

    <div>
        <hr>
        <div class="row">
            <div class="form-group col-sm-3" align="left">
                <input class="form-control" type="search" placeholder="Search"/>
            </div>
            <div class="form-group col-sm-8" align="right">
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#createCategory">
                    Export
                </button>
            </div>
            <div class="form-group col-sm-1" align="right">
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#createCategory">
                    Create
                </button>
            </div>
            <!-- Modal -->

        </div>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Unit Price</th>
                <th scope="col">In Stock</th>
                <th scope="col">Stock Alert</th>
                <th scope="col">#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${allItem}">
                <tr>
<<<<<<< HEAD
                    <td>${item.name}</td>
<%--                    <td>${item.category_id.name}</td>--%>
<%--                    <td>${item.mstItemVariant.price}</td>--%>
<%--                    <td>${item.mstItemVariant.price}</td>--%>
<%--                    <td>${item.mstItemVariant.itemInventory.alertAtQty}</td>--%>
=======
                    <td>${item.mstItemVariant.mstItem.name}</td>
                    <td>${item.mstItemVariant.mstItem.category_id.name}</td>
                    <td>${item.mstItemVariant.price}</td>
                    <td>${item.mstItemVariant.sku}</td>
                    <td>${item.alertAtQty}</td>
>>>>>>> 68da62ca97ae447b1647b3557dbf3f74a32ed819
                    <td><a data-toggle="modal" data-target="#editItem">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>


</body>
</html>