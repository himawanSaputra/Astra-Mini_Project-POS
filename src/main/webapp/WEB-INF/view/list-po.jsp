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

    <title>List Supplier</title>
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
<!-- Modal-->
<div class="modal" id="editPOModal" tabindex="-1" role="dialog" aria-labelledby="editPOModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editPOModalLabel">PURCHASE ORDER</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <%--                <form:form action="savePO" method="POST">--%>
                <%--                <form:hidden path="id" id="id"/>--%>
                <div class="container">

                    <div class="form-group">
                        <div class="form-row">
                            <label class="col-form-label"><h6>Edit NEW PO : OUTLET Login</h6></label>

                        </div>


                        <div class="form-row">

                            <label for="chooseSupplier" class="col-form-label">Choose Supplier</label>
                            <select id="chooseSupplier" class="form-control-lg custom-select">
                                <option value="volvo">PT. Dannpa Abadi</option>
                                <option value="saab">PT. Yoga Sejahtera</option>
                                <option value="mercedes">PT. John Doo</option>

                            </select>
                            <%--                            <form:select path="mstProvince.id" id="province" class="form-control custom-select">--%>
                            <%--                                <form:option value="0" label="-- Choose --" disabled="true"/>--%>
                            <%--                                <form:options items="${provinces}"  itemValue="id" itemLabel="name"/>--%>
                            <%--                            </form:select>--%>


                        </div>


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
                </div>
            </div>
            <div class="modal-footer">
                <input type="button" value="cancel" align="right" class="btn btn-secondary"
                       onclick="window.location.href='list';return false;"/>

                <input type="submit" id="formSubmit" value="save" class="btn btn-primary"/>
            </div>
            <%--            </form:form>--%>
        </div>
    </div>
</div>


<%--<div id="exampleModalHolder"></div>--%>

<!-- Modal-->

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

            <div class="form-group col-sm-2">

                <button type="button" id="btnExport" class="btn btn-secondary form-control" data-toggle="modal"
                        data-target="#editPOModal">Export
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

        <!-- construct an "update" link with customer id -->
        <%--            <c:url var="updateLink" value="/rest/supplier/get/">--%>
        <%--                <c:param name="supplierId" value="${tempSupplier.id}"/>--%>
        <%--            </c:url>--%>
        <tr>
            <td>30/07/97</td>
            <td>Dannpa</td>
            <td>PO001</td>
            <td>500000</td>
            <td>Approve</td>
            <td>
                <button class="btn btn-primary">Edit</button>
                <button class="btn btn-primary">View</button>
            </td>


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