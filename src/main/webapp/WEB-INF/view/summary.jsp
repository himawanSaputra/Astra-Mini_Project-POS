<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: agrmuham6900
  Date: 12/4/2019
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />"></script>
    <title>Summary</title>
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
            Summary
        </h3>
    </div>

    <div>
        <hr>
        <div class="row">
            <div class="form-group col-sm-3" align="left">
                <input class="form-control" type="date" placeholder="Date">
            </div>
            <div class="form-group col-sm-3" align="left">
                <input class="form-control" type="search" placeholder="Search">
            </div>
            <div class="form-group col-sm-2" align="right">
                <button type="button" class="btn btn-primary" data-toogle="modal" data-target="#createSummary">
                    Export
                </button>
            </div>
        </div>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name - Variant</th>
                <th scope="col">Category</th>
                <th scope="col">Beginning</th>
                <th scope="col">Purchase Order</th>
                <th scope="col">Sales</th>
                <th scope="col">Transfer</th>
                <th scope="col">Adjusment</th>
                <th scope="col">Ending</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${item}">
                <tr>
                    <td>${item.mstItemVariant.mstItem.name} - ${item.mstItemVariant.mstVariant.name}</td>
                </tr>
            </c:forEach>
            <c:forEach var="category" items="${category}">
                <tr>
                    <td>${category.name}</td>
                </tr>
            </c:forEach>
            <c:forEach var="inventory" items="${inventory}">
                <tr>
                    <td>${inventory.beginning}</td>
                </tr>
            </c:forEach>
            <c:forEach var="po" items="${po}">
                <tr>
                    <td>${po.id}</td>
                </tr>
            </c:forEach>
            <c:forEach var="so" items="${so}">
                <tr>
                    <td>${so.id}</td>
                </tr>
            </c:forEach>
            <c:forEach var="transferStock" items="${trasnsferStock}">
                <tr>
                    <td>${transferStock.id}</td>
                </tr>
            </c:forEach>
            <c:forEach var="adjusment" items="${adjusment}">
                <tr>
                    <td>${adjusment.id}</td>
                </tr>
            </c:forEach>
            <c:forEach var="inventory" items="${inventory}">
                <tr>
                    <td>${inventory.ending_qty}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
