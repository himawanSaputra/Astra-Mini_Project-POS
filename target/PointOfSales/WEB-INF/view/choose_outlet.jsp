<%--
  Created by IntelliJ IDEA.
  User: Himawan
  Date: 11/26/2019
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-min.css" />">
    <title>Point of Sales - Choose Outlet</title>
</head>
<body>
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-md-4 card p-4">
            <div class="row mb-4">
                <div class="col">
                    <h4 align="center">Choose Outlet</h4>
                </div>
            </div>

            <div class="row h-100 justify-content-center">
                <form:form method="post" action="/login_choose_outlet" modelAttribute="outlet">
                    <div class="dropdown form-group">
                        <form:select cssClass="btn btn-outline-primary dropdown-toggle" path="id">
                            <div class="dropdown-menu">
                                <form:option disabled="true" cssClass="dropdown-item" value="0" label="CHOOSE OUTLET"/>
                                <form:options cssClass="dropdown-item" items="${outlet_map}"/>
                            </div>
                        </form:select>
                    </div>
                    <div class="col-12">
                        <div class="row h-100 justify-content-center">
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>


