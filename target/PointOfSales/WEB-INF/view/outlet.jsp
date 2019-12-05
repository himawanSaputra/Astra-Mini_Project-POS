<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
<%--    modal--%>
    <div id="createOutlet" class="modal fade">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title">Input Outlet</h1>
                </div>
                <div class="modal-body">
                    <form:form method="post" name="outletForm" action="outlet" modelAttribute="outlet">
                        <form:input type="hidden" name="id" value="" path="id" id="id"/>
                        <form:input type="hidden" name="active" value="" path="active" id="active"/>
                        <div class="form-group">
                            <div>
                                <form:input placeholder="Outlet Name" type="outletname" class="form-control input-lg" name="outletname" path="name" id="outletname"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <form:input placeholder="Address" type="address" class="form-control input-lg" name="address" path="address" id="address"/>
                            </div>
                        </div>
                        <div class="form-inline row" style="display: inline-block; text-align: center; justify-content: center">

                                <form:select path="provinceId.id"  class="form-control select2" id="province"  >
                                    <form:option value="0" label="- Select Province-" disabled="true"/>
                                    <form:options items="${provinceList}" />
                                </form:select>

                                <form:select path="regionId.id"  class="form-control select2" id="region">
                                    <form:option value="0" label="- Select Region-" disabled="true"/>
                                    <form:options items="${regionList}"/>
                                </form:select>

                                <form:select path="districtId.id"  class="form-control select2" id="disctrict">
                                    <form:option value="0" label="- Select District-" disabled="true"/>
                                    <form:options items="${districtList}" />
                                </form:select>


                        </div>
                        <div class="form-inline row " style="display: inline-block; text-align: center; justify-content: center">
                            <div class="col-sm">
                                <form:input placeholder="Postal Code" type="postalcode" class="form-control input-lg" name="postalcode" path="postalCode" id="postalcode"/>
                            </div>
                            <div class="col-sm">
                                <form:input placeholder="Phone" type="phone" class="form-control input-lg" name="phone" path="phone" id="phone"/>
                            </div>
                            <div class="col">
                                <form:input placeholder="Email" type="email" class="form-control input-lg" name="email" path="email" id="email"/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->





    <h2>Outlets</h2>
    <div>
    <hr>
        <div class="container">

            <div class="row col-md">
                <div class="form-group ">
                    <form:form modelAttribute="outlets">
                        <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#createOutlet">Create</button>

                    </form:form>

                </div>

                <input class="form-control .col-sm-4" type="text" placeholder="Search" id="myInput"/>
            </div>

            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <td scope="col" style="display: none">Id </td>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <c:forEach var="outlet" items="${outlets}">
                        <tr >
                            <td style="display: none">${outlet.id}</td>
                            <td>${outlet.name}</td>
                            <td>${outlet.address}</td>
                            <td>${outlet.phone}</td>
                            <td>${outlet.email}</td>
                            <td><a data-toggle="modal" id="edit-outlet" onclick="toLink(${outlet.id})" data-target="#createOutlet">Edit</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</body>

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
<script>
   function toLink(id) {
       console.log("toLink"+id);

                $.ajax({
                    url: '${pageContext.request.contextPath}/rest/outlet/get/'+id,
                    method: 'GET',
                    dataType: 'json',
                    success: function (data) {
                        asd = JSON.stringify(data);
                        console.log(asd);
                        $('#id').val(data.id);
                        $('#active').val(data.active);
                        $('#outletname').val(data.name);
                        $('#address').val(data.address);
                        // $('#province').val(data.province);
                        // $('#region').val(data.region);
                        // $('#district').val(data.district);
                        $('#postalcode').val(data.postalCode);
                        $('#phone').val(data.phone);
                        $('#email').val(data.email);

                        if(data.mstProvince != null){
                            province.props('selected', data.mstProvince.id)
                        } else {
                            province.props('selected', 0)
                            region.empty();
                            district.empty();
                        }

                        if (data.mstRegion != null){
                            region.props('selected', data.mstRegion.id)
                        }else{
                            region.props('selected', 0)
                            district.empty();
                        }
                    },
                    error: function (error) {
                        alert(error);
                    }
                })
    }

</script>
</html>

