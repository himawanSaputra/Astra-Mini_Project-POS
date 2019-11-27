<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/27/2019
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />">
</head>
<body>
    <div class="row h-100 w-100">
        <div class="col-3">
            <div class="card">
                <div class="card-header text-center">
                    <h3>Adjustment</h3>
                </div>
                <div class="card-body text-center">
                    <h3 style="display: inline;" class="card-title">0</h3>
                    <p style="display: inline;">new</p>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="card">
                <div class="card-header text-center">
                    <h3>Transfer Stock</h3>
                </div>
                <div class="card-body text-center">
                    <h3 style="display: inline;" class="card-title">0</h3>
                    <p style="display: inline;">new</p>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="card">
                <div class="card-header text-center">
                    <h3>Purchase</h3>
                </div>
                <div class="card-body text-center">
                    <h3 style="display: inline;" class="card-title">0</h3>
                    <p style="display: inline;">new</p>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="card">
                <div class="card-header text-center">
                    <h3>Sales Order</h3>
                </div>
                <div class="card-body text-center">
                    <h3 style="display: inline;" class="card-title">0</h3>
                    <p style="display: inline;">new</p>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
