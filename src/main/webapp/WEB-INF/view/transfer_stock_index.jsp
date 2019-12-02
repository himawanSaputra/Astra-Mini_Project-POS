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
                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    To Outlet
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div>
        </div>
        <div class="col-1 p-0 text-right">
            <button class="btn btn-primary">Export</button>
        </div>
        <div class="col-1 p-0 text-right">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createTransferStockModal">
                Create
            </button>
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

<!-- Create new transfer stock modal -->
<div class="modal fade" id="createTransferStockModal" tabindex="-1" role="dialog" aria-labelledby="createTransferStockLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header align-middle">
                <h5 class="modal-title" id="createTransferStockLabel">Transfer Stock</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12 border-bottom">
                        <span>Create New Transfer Stock From: ${sessionScope.outlet.name}</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1">
                        <p>To</p>
                    </div>
                    <div class="col-12">
                        <select class="browser-default custom-select" name="to_outlet">
                            <option disabled selected>Select Outlet</option>
                            <c:forEach var="cur_outlet" items="${all_outlets}">
                                <c:if test="${cur_outlet.id != sessionScope.outlet.id}">
                                    <option value="${cur_outlet.id}">${cur_outlet.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1">
                        <p>Notes</p>
                    </div>
                    <div class="col-12">
                        <textarea class="w-100"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 border-bottom">
                        <p>Transfer Item</p>
                    </div>
                    <div class="col-12" hidden="hidden">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">Item</th>
                                <th scope="col">In Stock</th>
                                <th scope="col">Trans. Qty.</th>
                                <th scope="col">#</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-12">
                        <button type="button" class="btn btn-primary text-center w-100" data-toggle="modal" data-target="#exampleModal">
                            Add Transfer Item
                        </button>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" disabled  >Save & Submit</button>
            </div>
        </div>
    </div>
</div>

<!-- Add new transfer item modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Transfer Item</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div clas="row">
                    <input id="input_search_" type="text" placeholder="Item Name - Variant Name"/>
                </div>
                <div clas="row">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">Item</th>
                            <th scope="col">In Stock</th>
                            <th scope="col">Trans. Qty.</th>
                            <th scope="col">#</th>
                        </tr>
                        </thead>
                        <tbody id="add_transfer_item_tbody">

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Add</button>
            </div>
        </div>
    </div>
</div>
</html>

<script>
    function searchItem(search_word) {

    }
</script>
