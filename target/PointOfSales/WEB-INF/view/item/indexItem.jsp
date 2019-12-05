<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" href=<c:url value="/resources/bootstrap/css/bootstrap-min.css" />>--%>
<%--    <script src="<c:url value="/resources/bootstrap/js/bootstrap-min.js" />"></script>--%>
<%--    <title>Item</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>
</head>
<body>

<div class="container">

    <div>
        <div class="row">
            <div class="form-group col-sm-3" align="left">
                <input class="form-control" id="myInput" type="search" placeholder="Search"/>
            </div>
            <div class="form-group col-sm-8" align="right">
                <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#createCategory">
                    Export
                </button>
            </div>
            <div class="form-group col-sm-1" align="right">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#create-editItem">
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
            <tbody id="myTable">
            <c:forEach var="item" items="${items}">
                <tr>
<%--<<<<<<< HEAD--%>
<%--                    <td>${item.mstItemVariant.mstItem.name}</td>--%>
<%--                    <td>${item.mstItemVariant.mstItem.category_id.name}</td>--%>
<%--                    <td>${item.mstItemVariant.price}</td>--%>
<%--                    <td>${item.mstItemVariant.sku}</td>--%>
<%--                    <td>${item.alertAtQty}</td>--%>
<%--                    <td><a data-toggle="modal" data-target="#editItem">Edit</a></td>--%>
<%--=======--%>

                    <td>${item.mstItemVariant.mstItem.name}</td>
                    <td>${item.mstItemVariant.mstItem.category_id.name}</td>
                    <td>
                        <fmt:formatNumber type="currency" currencySymbol="Rp. " value="${item.mstItemVariant.price}">
                        </fmt:formatNumber>
                    </td>
                    <td>${item.beginning}</td>
                    <c:if test="${item.endingQty <= item.alertAtQty}">
                        <td>Low</td>
                    </c:if>
                    <c:if test="${item.endingQty > item.alertAtQty}">
                        <td>Normal</td>
                    </c:if></td>
<<<<<<< HEAD
                    <td><button data-toggle="modal" class="btn btn-primary" data-target="#create-editItem">Edit</button></td>


=======
                    <td><a data-toggle="modal" data-target="#create-editItem">Edit</a></td>
>>>>>>> e1bbd412862ecaa9f63704ffa893447e16d3f3d2
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
</body>

<div class="modal fade" id="create-editItem" tabindex="-1" role="dialog" aria-labelledby="create-editItem" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header align-middle">
                <h5 class="modal-title" id="createItemLabel">Items</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            <form:form method="post" name="itemForm" action="/saveItem" modelAttribute="item">
<%--                <form:hidden name="itemId" value="" path="mstItemVariant.mstItem.id" id="itemId"/>--%>
<%--                <form:hidden name="variantName" value="" path="mstItemVariant.name" id="varName"/>--%>
<%--                <form:hidden name="price" value="" path="mstItemVariant.price" id="price"/>--%>
<%--                <form:hidden name="sku" value="" path="mstItemVariant.sku" id="sku"/>--%>
<%--                <form:hidden name="beginStock" value="" path="beginning" id="beginStock"/>--%>
<%--                <form:hidden name="alertQty" value="" path="alertAtQty" id="alertQty"/>--%>
                <div class="row" style="margin-top: 15px; margin-bottom: 15px">
                    <div class="col-12">
                        <form:input class="form-control" name="itemName" path="mstItemVariant.mstItem.name" type="input" placeholder="Item Name"/>
                    </div>
                </div>
                <div class="row" style="margin-top: 15px; margin-bottom: 15px">
                    <div class="col-12">
                        <form:select path="mstItemVariant.mstItem.mstCategory.id" class="form-control select2" id="category"  >
                            <form:option value="0" label="-Select Category-"/>
                            <form:options items="${categoryList}" />
                        </form:select>
                    </div>
                </div>

                <div class="row" style="margin-top: 15px; margin-bottom: 15px">
                    <div class="col-1" align="left">
                        <h5>VARIANT</h5>
                    </div>
                    <div class="col-11" align="right">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-editVariant">
                            Add Variant
                        </button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th scope="col">Variant Name</th>
                                <th scope="col">Unit Price</th>
                                <th scope="col">SKU</th>
                                <th scope="col">Beginning Stock</th>
                                <th scope="col">#</th>
                            </tr>
                            </thead>
                            <tbody id="tableVariant">
                            <c:forEach var="item" items="${items}">
                                <tr>
                                    <td style="display: none">${item.mstItemVariant.id}</td>
                                    <input hidden name="varId" value="${item.mstItemVariant.id}">
                                    <input hidden name="varName" value="${item.mstItemVariant.name}">
                                    <input hidden name="sku" value="${item.mstItemVariant.sku}">
                                    <input hidden name="inStock" value="${item.beginning}">
                                    <input hidden name="alertAt" value="${item.alertAtQty}">
                                    <td>${item.mstItemVariant.name}</td>
                                    <td>
                                        <fmt:formatNumber type="currency" currencySymbol="Rp. ">
                                            ${item.mstItemVariant.price}
                                        </fmt:formatNumber>
                                    </td>
                                    <td>${item.mstItemVariant.sku}</td>
                                    <td>${item.beginning}</td>
                                    <td><a data-toggle="modal"  onclick="toLink(${item.mstItemVariant.id})" data-target="#add-editVariant">Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Back</button>
                <button type="reset" class="btn btn-outline-warning" >Cancel</button>
                <button type="submit" class="btn btn-primary" >Save</button>
            </div>
            </form:form>
        </div>
    </div>
</div>

<div class="modal fade" id="add-editVariant" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Variant</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form method="post" name="variantForm" action="/saveItem" modelAttribute="variant">
<%--                <form:input type="hidden" name="id" value="" path="id" id="id"/>--%>
                <div class="row">
                    <div class="col-6">
                        <input class="form-control" type="text" placeholder="Variant Name"/>
                    </div>
                    <div class="col-3">
                        <input type="text" class="form-control" placeholder="Unit Price" id="unitprice"/>
                    </div>
                    <div class="col-3">
                        <input type="text" class="form-control" placeholder="SKU" id="sku"/>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-7">
                            <h5>Set Beginning Alert</h5>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="Beginning Stock" id="beginstock"/>
                        </div>
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="Alert At" id="qtyalert"/>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="reset" class="btn btn-primary" >Cancel</button>
                <button type="button" class="btn btn-primary">Add</button>
            </div>
            </form:form>
        </div>
    </div>
</div>

</html>

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