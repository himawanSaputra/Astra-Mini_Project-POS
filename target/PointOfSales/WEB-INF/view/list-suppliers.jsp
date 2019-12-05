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
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">--%>

    <!-- jQuery library -->
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>

    <!-- Popper JS -->
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>--%>

    <!-- Latest compiled JavaScript -->
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>

</head>
<body>
<div class="row">
    <div class="col-12">

        <!-- Title -->
    <%--    <div class="row">--%>
    <%--        <div class="col-sm"><h2>Suppliers</h2></div>--%>
    <%--    </div>--%>

        <%-- Divider--%>
        <div class="row">
            <div class="col-sm">
                <hr/>
            </div>
        </div>

        <!-- Search , Export and Create -->
        <div class="row">

            <!-- Search button -->
            <div class="col-sm-8">
<%--                <form:form action="search" method="GET">--%>
                    <div class="input-group mb-3">
                        <input type="text" id="theSearchName" name="theSearchName" class="form-control" placeholder="Search by name"/>
<%--                        <div class="input-group-append">--%>
<%--                            <button type="submit" id="theSearchButton" value="Search" class="btn btn-primary">Search</button>--%>
<%--                        </div>--%>
                    </div>
<%--                </form:form>--%>
            </div>


            <div class="col-sm-2"></div>
            <!-- Export -->
            <div class="col-sm-1">
                <div align="right">
                    <button type="button" class="btn btn-secondary">Export</button>
                </div>
            </div>

            <!-- Create -->
            <div class="col-sm-1">
                <div align="right">
                    <c:if test="${sessionScope.user.mstRole.id == 1}">
                        <button type="button"
                                onclick="toLink(0)"
                                class="btn btn-primary">
                            Create
                        </button>
                    </c:if>
                </div>

            </div>
        </div>


        <br/>

        <!-- add out html table -->
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col" colspan="2">#</th>
            </tr>
            </thead>


            <tbody id="myTable">
            <!-- loop over and print out suppliers -->
            <c:forEach var="tempSupplier" items="${suppliers}">
                <tr>
                    <td>${tempSupplier.name}</td>
                    <td>${tempSupplier.phone}</td>
                    <td>${tempSupplier.email}</td>
                    <td>
                        <c:if test="${sessionScope.user.mstRole.id == 1}">
                            <a href="#" id="tesBtn" onclick="toLink(${tempSupplier.id})">Edit</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<!-- Modal-->
<div class="modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"
     th:fragment="">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Supplier Form</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form:form action="saveSupplier" modelAttribute="supplierForm" method="POST">
                <form:hidden path="id" id="id"/>
                <div class="container">

                    <div class="form-group">
                        <label for="name" class="col-form-label">Supplier Name</label>
                        <td colspan="2" id="nameTd"><form:input path="name" id="name"
                                                                placeholder="Supplier Name"
                                                                class="form-control"/></td>
                    </div>


                    <div class="form-group">
                        <label for="address" class="col-form-label">Address</label>
                        <td colspan="2"><form:input path="address" id="address" placeholder="Address"
                                                    class="form-control"/></td>
                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="province" class="col-form-label">Province</label>
                            <form:select path="mstProvince.id" id="province" class="form-control custom-select">
                                <form:option value="0" label="-- Choose --" disabled="true"/>
                                <form:options items="${provinces}"  itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>


                        <div class="form-group col-md-4">
                            <label for="region" class="col-form-label">Region</label>
                            <form:select path="mstRegion.id" id="region" name="source" class="form-control">
                                <form:option value="0" label = "-- Choose -- " disabled="true" />

                            </form:select>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="district" class="col-form-label">District</label>
                            <form:select path="mstDistrict.id" id="district" name="source" class="form-control">
                                <form:option value="0" label="-- Choose --" disabled="true"/>


                            </form:select>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="postalCode" class="col-form-label">Postal Code</label>
                            <form:input path="postalCode" id="postalCode" placeholder="Postal Code"
                                        class="form-control"/>

                        </div>

                        <div class="form-group col-md-8">
                            <label for="phone" class="col-form-label">Phone</label>
                            <form:input path="phone" id="phone" placeholder="Phone" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-form-label">Email</label>
                        <form:input path="email" id="email" placeholder="Email" class="form-control"/>
                    </div>


                </div>

            </div>
            <div class="modal-footer">
                <input type="button" value="Cancel" align="right" class="btn btn-secondary"
                       onclick="window.location.href='list';return false;"/>

                <input type="submit" id="formSubmit" value="Save"  class="btn btn-primary"/>
            </div>
            </form:form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("#theSearchName").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });

    function toLink(id) {
        let province = $('#province');
        let region = $('#region');
        let district1 = $('#district');

        console.log("toLink " + id);
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/supplier/get/" + id,
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {

                console.log(data);
                console.log(data.address);
                asd = JSON.stringify($(self).attr('address'));
                console.log('this is data name ' + $(this).attr('name'));
                console.log('this is data address ' + asd);
                // console.log("provinceId "+data.mstProvince.id);
                // console.log("regionId "+data.mstRegion.id);
                // console.log("districtId "+data.mstDistrict.id);

                // $('#exampleModalHolder').html(data);
                $('#exampleModal').modal('show');
                $(".modal-body #id").val(data.id);
                $(".modal-body #name").val(data.name);
                $(".modal-body #address").val(data.address);

                if(data.mstProvince != null){
                    province.prop('selectedIndex', data.mstProvince.id);
                }else{
                    province.prop('selectedIndex', 0);
                    region.empty();
                    district1.empty();

                }

                if(data.mstRegion != null){

                    region.empty();
                    region.append('<option selected="true" disabled>--Choose--</option>');

                    $.ajax({
                        url: "${pageContext.request.contextPath}/rest/region/getFromProvince/"+data.mstProvince.id,
                        contentType: 'application/json',
                        dataType: 'json',
                        success: function(dataRegion){

                            dataRegion.forEach(function (arrayItem) {
                                var x = arrayItem.name ;
                                console.log(x);
                                region.append($('<option></option>').attr('value', arrayItem.id).text(arrayItem.name));
                                <%--region.append($('<form:options >').attr({'value':"id", ' label':"name"}));--%>
<%--                                <form:options items="${provinces}"  itemValue="id" itemLabel="name"/>--%>

                            });

                            var regionId = data.mstRegion.id;
                            region.prop('selectedIndex',regionId);


                        }
                    });

                }

                if(data.mstDistrict != null){

                    district1.empty();
                    district1.append('<option selected="true" disabled>--Choose--</option>');
                    district1.prop('selectedIndex', 0);


                    $.ajax({
                        url: "${pageContext.request.contextPath}/rest/district/getFromRegion/"+data.mstRegion.id,
                        contentType: 'application/json',
                        dataType: 'json',
                        success: function(dataDistrict){

                            dataDistrict.forEach(function (arrayItem) {
                                var x = arrayItem.name ;
                                console.log(x);

                                district1.append($('<option></option>').attr('value', arrayItem.id).text(arrayItem.name));

                            });


                            var district = data.mstDistrict.id;
                            district1.prop('selectedIndex',district);
                        }

                    })
                }
                $(".modal-body #email").val(data.email);
                $(".modal-body #phone").val(data.phone);
                $(".modal-body #postalCode").val(data.postalCode);



            }
        });




    }


    $("#province").on('change', function(){
        var id = this.value;
        console.log(id);

        let district = $('#district');
        let region = $('#region');

        region.empty();
        district.empty();
        region.append('<option selected="true" disabled>--Choose--</option>');
        region.prop('selectedIndex', 0);

        if(this.value == 0){
            region.empty();
            district.empty();
            district.prop('selectedIndex', 0);
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/region/getFromProvince/"+id,
            contentType: 'application/json',
            dataType: 'json',
            success: function(data){

                data.forEach(function (arrayItem) {
                    var x = arrayItem.name ;
                    console.log(x);
                    region.append($('<option></option>').attr('value', arrayItem.id).text(arrayItem.name));

                });
            }
        });
    });

    $("#region").on('change', function(){
        var id = this.value;
        console.log("region id " + id);

        let district = $('#district');
        district.empty();

        district.append('<option selected="true" disabled>--Choose--</option>');
        district.prop('selectedIndex', 0);
        $.ajax({
            url: "${pageContext.request.contextPath}/rest/district/getFromRegion/"+id,
            contentType: 'application/json',
            dataType: 'json',
            success: function(data){
                data.forEach(function (arrayItem) {
                    var x = arrayItem.name ;
                    console.log(x);
                    district.append($('<option></option>').attr('value', arrayItem.id).text(arrayItem.name));

                });
            }
        })
    });
</script>
</body>

</html>