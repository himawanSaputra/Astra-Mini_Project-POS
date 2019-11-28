<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/28/2019
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Point of Sales - Transfer Stock</title>
</head>
<body>
    <div class="row">
        <div class="col-10 pl-0">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    To Outlet
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div>
        </div>
        <div class="col-1">
            <button class="btn btn-primary">Export</button>
        </div>
        <div class="col-1 pr-0">
            <button class="btn btn-primary">Create</button>
        </div>
    </div>
    <div class="row justify-content-center align-items-center">
        <div class="col-12 p-0 mt-3">
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Transfer Date</th>
                    <th scope="col">From Outlet</th>
                    <th scope="col">To Outlet</th>
                    <th scope="col">Status</th>
                    <th scope="col">#</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="transfer_stock" items="${transfer_stock_list}">
                    <tr>
                        <td>${transfer_stock.createdOn}</td>
                        <td>${transfer_stock.fromMstOutlet.name}</td>
                        <td>${transfer_stock.toMstOutlet.name}</td>
                        <td>${transfer_stock.status}</td>
                        <td><a href="/transfer_stock_detail/${transfer_stock.id}">View</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
