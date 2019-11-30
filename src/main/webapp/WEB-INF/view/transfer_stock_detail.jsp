<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/28/2019
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Point of Sales - Transfer Stock Detail</title>
</head>
<body>
<div class="row">
    <div class="col-10 pl-0 border-bottom">
        <h4 class="font-weight-bold">Detail</h4>
    </div>
    <div class="col-2 pr-0 text-right">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                More
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Approve</a>
                <a class="dropdown-item" href="#">Reject</a>
                <a class="dropdown-item" href="#">Print</a>
            </div>
        </div>
    </div>
</div>
<!-- TRANSFER STOCK DETAIL HEADER -->
<div class="row">
    <div class="col-12 p-0 mt-3">
        <p>Created By: ${transfer_stock.createdBy}</p>
        <p>Transfer Status: ${transfer_stock.status}</p>
        <p>Notes:</p>
        <textarea class="h-100" wrap="hard">${transfer_stock.notes}</textarea>
    </div>
</div>
<!-- TRANSFER STOCK STATUS HISTORY -->
<div class="row border-bottom mt-4">
    <h4 class="font-weight-bold">Status History</h4>
</div>
<div class="row">
    <div class="col-12 p-0 mt-3">
        <ul style="list-style-type: none;">
            <c:forEach var="transfer_stock_history"
                       items="${transfer_stock.tTransferStockHistoryList}">
                <p>On ${transfer_stock_history.createdOn} - ${transfer_stock_history.status}</p>
            </c:forEach>
        </ul>
    </div>
</div>
<!-- TRANSFER STOCK ITEMS -->
<div class="row border-bottom mt-4">
    <h4 class="font-weight-bold">Transfer Stock Items</h4>
</div>
<div class="row">
    <div class="col-12 p-0 mt-3">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Item</th>
                <th scope="col">In Stock</th>
                <th scope="col">Transfer Qty.</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="transfer_stock_detail" items="${transfer_stock.tTransferStockDetailList}">
                <tr>
                    <td>${transfer_stock_detail.variantId.mstItem.name} - ${transfer_stock_detail.variantId.name}</td>
                    <td>${transfer_stock_detail.instock}</td>
                    <td>${transfer_stock_detail.transferQty}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-12 text-right p-0">
        <button class="btn btn-primary">
            Done
        </button>
    </div>
</div>
</body>
</html>

