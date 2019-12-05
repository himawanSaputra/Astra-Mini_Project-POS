<%--
  Created by IntelliJ IDEA.
  User: dannpa
  Date: 11/21/2019
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <title>List Purchase Order</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<!-- Edit PO Modal-->
<div class="modal" id="editPOModal" tabindex="-1" role="dialog" aria-labelledby="editPOModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editPOModalLabel">PURCHASE ORDER</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form:form action="/update" modelAttribute="poForm" method="POST">
                <form:hidden path="id" id="id"/>
                <div class="modal-body">
                        <%--                <form:form action="savePO" method="POST">--%>
                        <%--                <form:hidden path="id" id="id"/>--%>
                    <div class="container">

                        <!-- Title -->
                        <div class="form-group">
                            <div class="form-row">

                                <label class="col-form-label"><h6>Edit NEW PO : OUTLET Login</h6></label>

                            </div>
                        </div>

                        <!-- Choose Supplier -->
                        <div class="form-group">
                            <div class="form-row">

                                <label for="chooseSupplier" class="col-form-label">Choose Supplier</label>
                                <form:select path="mstSupplier.id" id="chooseSupplier" class="form-control-lg custom-select">
                                    <option value="0" disabled>-- Choose Supplier --</option>
                                    <form:options items="${supplierList}" itemValue="id" itemLabel="name"/>
<%--                                    <c:forEach var="supplier" items="${supplierList}">--%>
<%--                                        <option value="${supplier.id}">${supplier.name}</option>--%>
<%--                                    </c:forEach>--%>

                                </form:select>
                                    <%--                            <form:select path="mstProvince.id" id="province" class="form-control custom-select">--%>
                                    <%--                                <form:option value="0" label="-- Choose --" disabled="true"/>--%>
                                    <%--                                <form:options items="${provinces}"  itemValue="id" itemLabel="name"/>--%>
                                    <%--                            </form:select>--%>


                            </div>
                        </div>

                        <!-- Notes -->
                        <div class="form-group">
                            <div class="form-row">
                                <label for="exampleFormControlTextarea1">Notes</label>
                                <textarea style="min-width: 100%" class="form-control col-5"
                                          id="exampleFormControlTextarea1" rows="4"></textarea>


                                    <%--                            <label for="postalCode" class="col-form-label">Postal Code</label>--%>
                                    <%--                            <form:input path="postalCode" id="postalCode" placeholder="Postal Code"--%>
                                    <%--                                        class="form-control"/>--%>


                                <div class="form-group col-md-8">
                                        <%--                            <label for="phone" class="col-form-label">Phone</label>--%>
                                        <%--                            <form:input path="phone" id="phone" placeholder="Phone" class="form-control"/>--%>
                                </div>
                            </div>

                            <div class="form-group">
                                    <%--                        <label for="email" class="col-form-label">Email</label>--%>
                                    <%--                        <form:input path="email" id="email" placeholder="Email" class="form-control"/>--%>
                            </div>


                        </div>


                        <!-- Table PO in Modal -->
                        <div class="form-group">
                            <label class="col-form-label">Purchase Order</label>
                            <hr id="hr">
                            <table id="editTable" class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Item</th>
                                    <th scope="col">In Stock</th>
                                    <th scope="col">Qty</th>
                                    <th scope="col">Unit Cost</th>
                                    <th scope="col">SubTotal</th>

                                </tr>

                                </thead>


                                <tbody>
                                <!-- loop over and print out customers -->
                                    <%--        <c:forEach var="tempSupplier" items="${suppliers}">--%>

                                <!-- construct an "update" link with customer id -->
                                    <%--            <c:url var="updateLink" value="/rest/supplier/get/">--%>
                                    <%--                <c:param name="supplierId" value="${tempSupplier.id}"/>--%>
                                    <%--            </c:url>--%>
                                <tr>
                                    <td>Baju Merah</td>
                                    <td>3</td>
                                    <td>10</td>
                                    <td>50000</td>
                                    <td>500000</td>

                                </tr>
                                <tr>
                                    <td>Baju Biru</td>
                                    <td>2</td>
                                    <td>10</td>
                                    <td>40000</td>
                                    <td>400000</td>

                                </tr>
                                <tr>
                                    <td colspan="4"><b>TOTAL</b></td>
                                    <td colspan="1">Rp. 900000</td>
                                </tr>


                                    <%--            <tr>--%>
                                    <%--                <td>${tempSupplier.name}</td>--%>
                                    <%--                <td>${tempSupplier.phone}</td>--%>
                                    <%--                <td>${tempSupplier.email}</td>--%>
                                    <%--                <td>--%>
                                    <%--                    <!-- display the update button -->--%>
                                    <%--                    <button type="button" id="tesBtn" class="btn btn-info" onclick="toLink(${tempSupplier.id})">Edit--%>
                                    <%--                    </button>--%>

                                    <%--                </td>--%>
                                    <%--                <td>--%>

                                    <%--                </td>--%>
                                    <%--            </tr>--%>

                                    <%--        </c:forEach>--%>
                                </tbody>

                            </table>

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" value="cancel" align="right" class="btn btn-secondary"
                           onclick="window.location.href='list';return false;"/>

                    <input type="submit" value="save" class="btn btn-primary"/>
                </div>

            </form:form>

            <%--            </form:form>--%>
        </div>
    </div>
</div>


<div class="modal" id="viewPOModal" tabindex="-1" role="dialog" aria-labelledby="editPOModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable " role="document">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title" id="viewPOModalLabel">PURCHASE ORDER DETAIL</h4>
                <div class="col-sm-1"></div>

                <select class="custom-select col-sm-2">
                    <option value="volvo">More</option>
                    <option value="saab">Approve</option>
                    <option value="mercedes">Reject</option>
                    <option value="asdf">Process</option>
                    <option value="print">Print</option>

                </select>

                <button type="button col-sm-1" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <%--                <form:form action="savePO" method="POST">--%>
                <%--                <form:hidden path="id" id="id"/>--%>
                <div class="container">

                    <div class="form-group">
                        PT Maju Jaya Sekali
                        <table class="table table-borderless table-sm" >
                            <tbody>
                            <tr >
                                <td style="border: 1px dashed;">021-1234678</td>
                                <td colspan="2" style="border: 1px dashed;">mjs@email.com</td>
                            </tr>
                            <tr>
                                <td colspan="3" style="border: 1px dashed;">Jl Bangun woy udah pagi</td>
                            </tr>
                            <tr>
                                <td style="border: 1px dashed;">Jawa Barat</td>
                                <td style="border: 1px dashed;">Bandung</td>
                                <td style="border: 1px dashed;">21345</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>


                    <!-- Notes -->
                    <div class="form-group">
                        <div class="form-row">
                            <label for="exampleFormControlTextarea1">Notes</label>
                            <textarea style="min-width: 100%" class="form-control col-5"
                                      id="exampleFormControlTextarea1" rows="4"></textarea>


                            <%--                            <label for="postalCode" class="col-form-label">Postal Code</label>--%>
                            <%--                            <form:input path="postalCode" id="postalCode" placeholder="Postal Code"--%>
                            <%--                                        class="form-control"/>--%>


                            <div class="form-group col-md-8">
                                <%--                            <label for="phone" class="col-form-label">Phone</label>--%>
                                <%--                            <form:input path="phone" id="phone" placeholder="Phone" class="form-control"/>--%>
                            </div>
                        </div>

                        <div class="form-group">
                            <%--                        <label for="email" class="col-form-label">Email</label>--%>
                            <%--                        <form:input path="email" id="email" placeholder="Email" class="form-control"/>--%>
                        </div>


                    </div>

                    <table>
                        <tbody>
                        <tr>
                            <td>PO Number : PO0001</td></tr>
                        <tr><td>Created By</td></tr>
                        <tr><td>Email</td></tr>
                        <tr><td>Outlet</td></tr>
                        <tr><td>Phone</td></tr>
                        <tr><td>Address</td></tr>
                        <tr><td>PO Status</td></tr>
                        </tbody>
                    </table>

                    <br>
                    <br>

                    Status History
                    <hr/>
                    On 01/01/2016 - PO0012 isCreated <br>
                    On 01/01/2016 - PO0023 is Modified

                    <br><br>

                    <!-- Table PO in Modal -->
                    <div class="form-group">
                        <label class="col-form-label">Purchase Order</label>
                        <hr id="hr1">
                        <table class="table">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">Item</th>
                                <th scope="col">In Stock</th>
                                <th scope="col">Qty</th>
                                <th scope="col">Unit Cost</th>
                                <th scope="col">SubTotal</th>

                            </tr>

                            </thead>


                            <tbody>
                            <!-- loop over and print out customers -->
                            <%--        <c:forEach var="tempSupplier" items="${suppliers}">--%>


                            <!-- construct an "update" link with customer id -->
                            <%--            <c:url var="updateLink" value="/rest/supplier/get/">--%>
                            <%--                <c:param name="supplierId" value="${tempSupplier.id}"/>--%>
                            <%--            </c:url>--%>
                            <tr>
                                <td>Baju Merah</td>
                                <td>3</td>
                                <td>10</td>
                                <td>50000</td>
                                <td>500000</td>

                            </tr>
                            <tr>
                                <td>Baju Biru</td>
                                <td>2</td>
                                <td>10</td>
                                <td>40000</td>
                                <td>400000</td>

                            </tr>
                            <tr>
                                <td colspan="4"><b>TOTAL</b></td>
                                <td colspan="1">Rp. 900000</td>
                            </tr>


                            <%--            <tr>--%>
                            <%--                <td>${tempSupplier.name}</td>--%>
                            <%--                <td>${tempSupplier.phone}</td>--%>
                            <%--                <td>${tempSupplier.email}</td>--%>
                            <%--                <td>--%>
                            <%--                    <!-- display the update button -->--%>
                            <%--                    <button type="button" id="tesBtn" class="btn btn-info" onclick="toLink(${tempSupplier.id})">Edit--%>
                            <%--                    </button>--%>

                            <%--                </td>--%>
                            <%--                <td>--%>

                            <%--                </td>--%>
                            <%--            </tr>--%>

                            <%--        </c:forEach>--%>
                            </tbody>

                        </table>

                    </div>
                </div>
            </div>
            <div class="modal-footer">
<%--                <input type="button" value="cancel" align="right" class="btn btn-secondary"--%>
<%--                       onclick="window.location.href='list';return false;"/>--%>

                <input type="submit" id="formSubmit" value="Done" class="btn btn-primary"/>
            </div>
            <%--            </form:form>--%>
        </div>
    </div>
</div>


<div class="container-fluid">

    <!-- Title -->
    <div class="row">
        <div class="col-sm"><h2>Purchase Order</h2></div>
    </div>

    <%-- Divider--%>
    <div class="row">
        <div class="col-sm">
            <hr/>
        </div>
    </div>

    <form>
        <div class="form-row">

            <!-- Date From -->
            <div class="form-group col-sm-2">
                <div class="form-row">
                    <div class="form-group">
                        <label for="dateFrom">From</label>
                        <input id="dateFrom"/>
                        <script>
                            $('#dateFrom').datepicker({
                                uiLibrary: 'bootstrap4'
                            });
                        </script>

                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="dateTo">To</label>
                        <input id="dateTo"/>
                        <script>
                            $('#dateTo').datepicker({
                                uiLibrary: 'bootstrap4'
                            });
                        </script>
                    </div>
                </div>

            </div>

            <!-- Status -->
            <div class="form-group col-sm-2">
                <label for="status">Status</label>
                <select id="status" class="form-control custom-select">
                    <option value="0">Test 0</option>
                    <option value="2">Test 1</option>
                </select>

            </div>

            <!-- Notes -->
            <div class="form-group col-sm-3">
                <label for="searchGroup">Search</label>
                <div class="input-group mb-3" id="searchGroup">
                    <input type="text" id="theSearch" name="theSearch" class="form-control" placeholder="Search Here"/>
                    <div class="input-group-append">
                        <button type="submit" id="theSearchButton" value="Search" class="btn btn-primary">Search
                        </button>
                    </div>
                </div>
            </div>

            <div class="form-group col-sm-3"></div>

            <div class="form-group col-sm-2 col-md-offset-3 column">

                <label for="btnExport" style="color: white">dlsdjklfsd</label>
                <button type="button" id="btnExport" class="btn btn-secondary form-control text-center">
                    Export
                </button>

            </div>

        </div>
        <%--        <div class="form-row">--%>

        <%--            <!-- Date From -->--%>
        <%--            <div class="form-group col-sm-3">--%>
        <%--&lt;%&ndash;                <label for="dateTo">Date To</label>&ndash;%&gt;--%>
        <%--                <input id="dateTo"/>--%>
        <%--                <script>--%>
        <%--                    $('#dateTo').datepicker({--%>
        <%--                        uiLibrary: 'bootstrap4'--%>
        <%--                    });--%>
        <%--                </script>--%>
        <%--            </div>--%>
        <%--        </div>--%>

    </form>


    <br/>


    <!-- add out html table -->
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Create Date</th>
            <th scope="col">Supplier</th>
            <th scope="col">PO No.</th>
            <th scope="col">Total</th>
            <th scope="col">Status</th>
            <th scope="col" colspan="2">#</th>
        </tr>
        </thead>


        <tbody>

        <!-- loop over and print out customers -->
        <%--        <c:forEach var="tempSupplier" items="${suppliers}">--%>

        <c:forEach var="tempPO" items="${orderList}">
            <td>${tempPO.createdOn}</td>
            <td>${tempPO.mstSupplier.name}</td>
            <td>${tempPO.poNo}</td>
            <td>${tempPO.grandTotal}</td>
            <td>${tempPO.status}</td>
            <td>
                <button class="btn btn-primary" data-toggle="modal"
                        data-target="#editPOModal">Edit</button>
                <button class="btn btn-primary" data-toggle="modal"
                        data-target="#viewPOModal">View</button>
            </td>


        </c:forEach>
        <!-- construct an "update" link with customer id -->
        <%--            <c:url var="updateLink" value="/rest/supplier/get/">--%>
        <%--                <c:param name="supplierId" value="${tempSupplier.id}"/>--%>
        <%--            </c:url>--%>
        <tr>



        </tr>


        <%--            <tr>--%>
        <%--                <td>${tempSupplier.name}</td>--%>
        <%--                <td>${tempSupplier.phone}</td>--%>
        <%--                <td>${tempSupplier.email}</td>--%>
        <%--                <td>--%>
        <%--                    <!-- display the update button -->--%>
        <%--                    <button type="button" id="tesBtn" class="btn btn-info" onclick="toLink(${tempSupplier.id})">Edit--%>
        <%--                    </button>--%>

        <%--                </td>--%>
        <%--                <td>--%>

        <%--                </td>--%>
        <%--            </tr>--%>

        <%--        </c:forEach>--%>
        </tbody>

    </table>
</div>
</body>

</html>