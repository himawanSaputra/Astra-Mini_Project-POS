<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Outlets</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<<<<<<< HEAD


<div class="container">
<%--    modal--%>
    <div id="createOutlet" class="modal fade">
        <div class="modal-dialog modal-lg" role="document">
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
<<<<<<< HEAD
                <div>
                    <input class="form-control col-sm-12 " align="left" type="search" placeholder="Search" id="myInput"/>
                </div>
                <div class="form-group col-sm-9" align="right">
                        <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#createOutlet">
                            Create
                        </button>
=======
                <div class="form-group ">
                    <form:form modelAttribute="outlets">
                        <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#createOutlet">Create</button>

                    </form:form>

=======
    <div class="row">
        <div class="col-12">
            <div class="row">
                <div class="col-6">
                    <input class="form-control" type="text" placeholder="Search" id="myInput"/>
                </div>
                <div class="col-6 form-group text-right">
                    <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#exampleModal" onclick="clearForm()">
                        Create
                    </button>
>>>>>>> 5221519aa7f51d823f669bf5d388673b46c14c87
>>>>>>> 0f100f4690022d50412a45bbf7d3fef4381f3364
                </div>
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
                    <c:forEach var="cur_outlet" items="${outlets}">
                        <tr >
                            <td style="display: none">${cur_outlet.id}</td>
                            <td>${cur_outlet.name}</td>
                            <td>${cur_outlet.address}</td>
                            <td>${cur_outlet.phone}</td>
                            <td>${cur_outlet.email}</td>
                            <td>
                                <a data-toggle="modal" href="#" id="edit-outlet" onclick="toLink(${cur_outlet.id})" data-target="#createOutlet">
                                    Edit
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<!-- Create New Outlet -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form:form method="post" name="outletForm" action="/add_outlet" modelAttribute="outlet">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Create Outlet</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-12">
                            <form:input type="hidden" name="id" value="" path="id" id="id"/>
                            <form:input type="hidden" name="active" value="" path="active" id="active"/>
                            <div class="row">
                                <div class="col-12">
                                    <form:input placeholder="Outlet Name" type="outletname"
                                                class="form-control input-lg" name="outletname"
                                                path="name" id="outletname" required="required"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <form:input placeholder="Address" type="address" class="form-control input-lg" name="address" path="address" id="address"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <form:select path="provinceId.id"  class="form-control" id="province" required="required">
                                        <form:option value="0" label="-Select Province-" disabled="true"/>
                                        <form:options items="${provinceList}" />
                                    </form:select>
                                </div>

                                <div class="col-4">
                                    <form:select path="regionId.id"  class="form-control" id="region" required="required">
                                        <form:option value="0" label="-Select Region-" disabled="true"/>
                                        <form:options items="${regionList}"/>
                                    </form:select>
                                </div>

                                <div class="col-4">
                                    <form:select path="districtId.id"  class="form-control" id="district" required="required">
                                        <form:option  value="0" label="-Select District-" disabled="true"/>
                                        <form:options items="${districtList}" />
                                    </form:select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <form:input placeholder="Postal Code" type="postalcode" class="form-control input-lg" name="postalcode" path="postalCode" id="postalcode"/>
                                </div>
                                <div class="col-4">
                                    <form:input placeholder="Phone" type="phone" class="form-control input-lg" name="phone" path="phone" id="phone"/>
                                </div>
                                <div class="col-4">
                                    <form:input placeholder="Email" type="email" class="form-control input-lg" name="email" path="email" id="email"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-12 text-right">
                            <button class="btn btn-secondary" onclick="clearForm()" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </div>
            </form:form>
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

    function clearForm(){
        $(".form-control").each(function(){
            $(this).val('');
        });
        $("#province").val(0);
        $("#region").val(0);
        $("#district").val(0);
    }

   function toLink(id) {
        $.ajax({
            url: '${pageContext.request.contextPath}/edit_outlet/'+id,
            method: 'GET',
            success: function (data) {
                $('#id').val(data.id);
                $('#active').val(data.active);
                $('#outletname').val(data.name);
                $('#address').val(data.address);
                $('#province').val(data.provinceId.id);
                $('#region').val(data.regionId.id);
                $('#district').val(data.districtId.id);
                $('#postalcode').val(data.postalCode);
                $('#phone').val(data.phone);
                $('#email').val(data.email);
                $('#exampleModal').modal('show');
            },
            error: function (error) {
                alert(error);
            }
        })
    }

</script>
</html>

