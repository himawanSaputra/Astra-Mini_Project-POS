<%--
  Created by IntelliJ IDEA.
  User: dannp
  Date: 11/21/2019
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Supplier</title>

<%--    <link rel="stylesheet"--%>
<%--          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
<%--          crossorigin="anonymous">--%>
    <!-- reference our style sheet -->
    <%--    <link type="text/css"--%>
    <%--          rel="stylesheet"--%>
    <%--          href="${pageContext.request.contextPath }/resources/css/style.css"/>--%>
</head>
<body>

<div id="wrapper" style="margin-right: 50px; margin-left: 50px">
    <div id="header">
        <h2>Suppliers</h2>
    </div>
</div>

<div id="container">
    <div id="content" style="margin-right: 50px; margin-left: 50px" >

        <div align="right">
            <!-- put new Button: Add Button -->
            <input type="button" value="Create"
                   onClick="window.location.href='supplierForm';return false;"
                   class="btn btn-primary"
            />
        </div>

        <br/>

        <%--        <form:form action="search" method="GET">--%>
        <%--            Search Customer: <input type="text" name="theSearchName"/>--%>
        <%--            <input type="submit" value="Search" class="add-button"/>--%>
        <%--        </form:form>--%>
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


            <tbody>
            <!-- loop over and print out customers -->
            <c:forEach var="tempSupplier" items="${suppliers}">

                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/supplier/updateSupplier">
                    <c:param name="supplierId" value="${tempSupplier.id}"/>
                </c:url>

                <%--                <c:url var="deleteLink" value="/supplier/deleteSupplier">--%>
                <%--                    <c:param name="supplierId" value="${tempSupplier.id}"/>--%>
                <%--                </c:url>--%>

                <tr>
                    <td>${tempSupplier.name}</td>
                    <td>${tempSupplier.phone}</td>
                    <td>${tempSupplier.email}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Edit</a>
                    </td>
                        <%--                    <td>--%>
                        <%--                        <!-- direct delete -->--%>
                        <%--                        <a href="${deleteLink}">Delete</a>--%>
                        <%--                    </td>--%>
                </tr>

            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

</body>

</html>