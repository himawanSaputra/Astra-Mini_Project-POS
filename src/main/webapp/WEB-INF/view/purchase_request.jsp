<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: liamra
  Date: 12/4/2019
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Purchase Request</title>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<%--    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>--%>
<%--    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>--%>
<%--    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"--%>
<%--          rel = "stylesheet">--%>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>
<body>
<div class="row">
    <div class="col-12">


<%--        for input--%>
        <div class="row" style="margin-bottom: 25px">
<%--            <form:form action="/purchase_request" name="purchaseRequestForm" method="post" modelAttribute="listTPr">--%>
            <div class="row col-8">
<%--                    <hidden path=""/>--%>
                <div class="col-auto " >
                    <input type="text" name="datefilter" value="" placeholder="Date"  class="form-control"/>
                </div>
                <div class="col-auto ">
                    <select class="custom-select form-control " >
                            <option value="select" disabled selected>-Select Status-</option>
                            <option value="submitted">Submitted</option>
                            <option value="rejected">Rejected</option>
                    </select>
                </div>
                <div class="col-auto">
                    <input  class="form-control" placeholder="Search"/>
                </div>
            </div>
<%--            </form:form>--%>

            <div class="row col-4">
                <div class="col-md-6">
                    <button class="btn btn-primary">Export</button>
                </div>

                <div class="col-md-auto">
                    <button class="btn btn-primary"type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#exampleModal">Create</button>
                </div>
            </div>
        </div>

        <div>
            <div class="row">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Create Date</th>
                        <th scope="col">PR No.</th>
                        <th scope="col">Note</th>
                        <th scope="col">Status</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cur_listTPrDetail" items="${listTPrDetail}">
                        <tr>
                                <td>${cur_listTPrDetail.tPr.createdOn}</td>
                                <td>${cur_listTPrDetail.tPr.prNo}</td>
                                <td>${cur_listTPrDetail.tPr.notes}</td>
                                <td>${cur_listTPrDetail.tPr.status} </td>
                                <td>
                                   <button class="btn btn-primary">
                                        Edit
                                   </button>
                                    <button class="btn btn-outline-primary">
                                        View
                                    </button>
                                </td>
                            </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>

<!-- Modal First -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Purchase Request</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12" >
                        <div class="row" style="margin-left: 15px; margin-right: 15px">
                            <h4>CREATE NEW PR</h4>
                        </div>
                        <hr style="border-bottom: 0.5px dashed #ccc;background: #999; margin-top: -2px">
                        <div class="row" style="margin-left: 15px; margin-right: 15px">
                            <h5>Target Waktu Item Ready</h5>
                            <input class="form-control" type="date"  value="" placeholder="Date"/>
                        </div>
                        <div class="row" style="margin-left: 15px; margin-right: 15px">
                            <h5>Notes</h5>
                            <textarea class="form-control" type="text"  value="" > </textarea>
                        </div>
                        <div class="row" style="margin-left: 15px; margin-right: 15px; margin-top: 25px">
                            <h5>Purchase Request</h5>
                        </div>
                        <hr style="border-bottom: 0.5px dashed #ccc;background: #999;margin-top: -2px">
                        <div class="row" style="margin-left: 15px; margin-right: 15px; margin-top: 25px">
                            <button class="btn btn-primary btn-block  text-center w-100" data-target="#modal2"  data-toggle="modal"> Add Item</button>
                        </div>
                        <div  class="row float-right " style="margin-left: 15px; margin-right: 15px; margin-top: 10px">
                            <button class="btn btn-default  mr-4" data-dismiss="modal"> Cancel</button>
                            <button class="btn btn-primary " > Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Second -->
<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Add Purchase Item</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12">
                        <div class="row" style="margin-left: 15px; margin-right: 15px">
                            <input  class="form-control" placeholder="Item Name - Variant Name"/>
                        </div>
                        <div class="row" style="margin-left: 15px; margin-right: 15px">
                            <table class="table table-light">
                                <thead>
                                <tr>
                                    <th scope="col">Item</th>
                                    <th scope="col">In Stock</th>
                                    <th scope="col">Request Qty.</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Baju</td>
                                    <td>3</td>
                                    <td>10</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function() {

        $('input[name="datefilter"]').daterangepicker({
            autoUpdateInput: false,
            locale: {
                cancelLabel: 'Clear'
            }
        });

        $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
            $(this).val(picker.startDate.format('DD/MM/YYYY') + ' - ' + picker.endDate.format('DD/MM/YYYY'));
        });

        $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
            $(this).val('');
        });
    });
</script>


</html>
